package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductDescriptionValidationRuleTest {

    @InjectMocks
    private ProductDescriptionValidationRule victim;

    @Test
    public void productDescriptionShouldNotBeEmpty() {
        String[] invalidDescriptions = {
                null,
                "",
                " "
        };

        for (String invalidDescription : invalidDescriptions) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidDescription)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE);
        }
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