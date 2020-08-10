package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ProductPriceValidationRuleTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ProductPriceValidationRule victim;

    private static final Object[] getInvalidPrice() {
        return new String[][]{{null}, {""}, {" "}, {"a"}};
    }

    private static final Object[] getInvalidPriceRange() {
        return new String[][]{{"-1"}, {"0"}};
    }

    @Test
    @Parameters(method = "getInvalidPrice")
    public void shouldThrowIVEForInvalidPriceFormat(String invalidPriceFormat) {
        assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceFormat)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_PRICE_EMPTY_EXCEPTION_MESSAGE);
    }

    @Test
    @Parameters(method = "getInvalidPriceRange")
    public void shouldThrowIVEForInvalidPriceRange(String invalidPriceRange) {
        assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceRange)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_PRICE_IS_ZERO_EXCEPTION_MESSAGE);
    }

    private ProductDto getProductDto(String price) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("NAME");
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice(price);
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory("CATEGORY");

        return productDto;
    }
}