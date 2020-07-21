package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {

    private final ProductNameValidationRule victim = new ProductNameValidationRule();

    @Test
    public void productNameShouldNotBeEmpty() {
        String[] invalidNames = {
                null,
                "",
                " "
        };

        for (String invalidName : invalidNames) {
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidName)));

            String expectedMessage = "Product name must not be null or blank or empty.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    public void productNameShouldNotBeToShortOrToLong() {
        String[] invalidNames = {
                "a",
                new String((new char[33])).replace('\0', 'a')
        };

        for (String invalidName : invalidNames) {
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidName)));

            String expectedMessage = "Product name length must be from 3 to 32 characters long.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    public void productNameShouldNotDuplicate() {

        victim.validate(getProductDto("name"));

        Exception exception = assertThrows(ItemValidationException.class,
                () -> victim.validate(getProductDto("name")));

        String expectedMessage = "Product name already exist in DB. Please choose different product name.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    private ProductDto getProductDto(String invalidName) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName(invalidName);
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice("PRICE");
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory("CATEGORY");

        return productDto;
    }

}