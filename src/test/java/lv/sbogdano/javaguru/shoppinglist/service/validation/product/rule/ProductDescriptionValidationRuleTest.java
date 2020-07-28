package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductDescriptionValidationRuleTest {

    private final ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();

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
                    .hasMessage("Product description must not be null or blank or empty.");
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