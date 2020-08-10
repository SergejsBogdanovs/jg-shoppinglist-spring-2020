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
public class ProductDiscountValidationRuleTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ProductDiscountValidationRule victim;

    private static final Object[] getInvalidDiscounts() {
        return new String[][]{{null}, {""}, {" "}, {"a"}, {"-1"}, {"101"}};
    }

    @Test
    @Parameters(method = "getInvalidDiscounts")
    public void shouldThrowIVEForInvalidDiscount(String invalidDiscountFormat) {
        assertThatThrownBy(() -> victim.validate(getProductDto(invalidDiscountFormat)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_DISCOUNT_WRONG_FORMAT_EXCEPTION);
    }

    @Test
    public void shouldThrowIVEIfPriceIsSmall() {
        assertThatThrownBy(() -> victim.validate(getProductDto("10")))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_DISCOUNT_PRICE_IS_SMALL_EXCEPTION);
    }

    private ProductDto getProductDto(String discount) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("NAME");
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice("19");
        productDto.setDiscount(discount);
        productDto.setCategory("CATEGORY");

        return productDto;
    }

}