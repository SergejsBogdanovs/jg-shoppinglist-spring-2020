package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductCategoryValidationRuleTest {

    private final ProductCategoryValidationRule victim = new ProductCategoryValidationRule();

    @Test
    public void productCategoryShouldNotBeEmpty() {
        String[] invalidCategories = {
                null,
                "",
                " "
        };

        for (String invalidCategory : invalidCategories) {
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidCategory)));

            String expectedMessage = "Product category must not be null or blank or empty.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    private ProductDto getProductDto(String category) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("NAME");
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice("PRICE");
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory(category);

        return productDto;
    }

}