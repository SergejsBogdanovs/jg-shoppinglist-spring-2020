package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

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
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidDescription)));

            String expectedMessage = "Product description must not be null or blank or empty.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
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