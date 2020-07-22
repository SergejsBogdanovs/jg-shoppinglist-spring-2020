package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDiscountValidationRuleTest {

    private final ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    @Test
    public void productDiscountShouldBeNumber() {
        String[] invalidDiscountFormats = {null, "", " ", "a", "-1", "101"};

        for (String invalidDiscountFormat : invalidDiscountFormats) {
            Exception exception = assertThrows(ItemValidationException.class,
                    () -> victim.validate(getProductDto(invalidDiscountFormat)));

            String expectedMessage = "Wrong discount format. Please enter number between 0 and 100.";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    public void ifPriceIsSmallDiscountNotAllowed() {
        Exception exception = assertThrows(ItemValidationException.class,
                () -> victim.validate(getProductDto("10")));

        String expectedMessage = "Can not make discount because price is less than $20.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
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