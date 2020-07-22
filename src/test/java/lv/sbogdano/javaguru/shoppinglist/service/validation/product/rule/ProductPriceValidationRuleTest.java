package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductPriceValidationRuleTest {

    private final ProductPriceValidationRule victim = new ProductPriceValidationRule();

    @Test
    public void productPriceShouldNotBeNull() {
        String[] invalidPriceFormats = {null, "", " ", "a"};

        for (String invalidPriceFormat : invalidPriceFormats) {
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidPriceFormat)));

            String expectedMessage = "Product price must not be null.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    public void productDiscountShouldNotBeLessThanZero() {
        String[] invalidPriceFormats = {"-1", "0"};

        for (String invalidPriceFormat : invalidPriceFormats) {

            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidPriceFormat)));

            String expectedMessage = "Product price must not be 0 or less.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
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