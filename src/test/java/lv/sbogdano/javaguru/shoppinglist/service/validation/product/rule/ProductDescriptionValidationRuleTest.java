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

@RunWith(JUnitParamsRunner.class)
public class ProductDescriptionValidationRuleTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ProductDescriptionValidationRule victim;

    private static final Object[] getInvalidDescription() {
        return new String[][]{{null}, {""}, {" "}};
    }

    @Test
    @Parameters(method = "getInvalidDescription")
    public void shouldThrowIVEForInvalidDescription(String invalidDescription) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidDescription)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE);
    }

    private ProductDto getProductDto(String description) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("NAME");
        productDto.setDescription(description);
        productDto.setPrice("PRICE");
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory("CATEGORY");

        return productDto;
    }

}