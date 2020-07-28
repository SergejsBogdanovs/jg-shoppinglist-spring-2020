package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class ProductPriceValidationRuleTest {

    private final ProductPriceValidationRule victim = new ProductPriceValidationRule();

    @Test
    public void productPriceShouldNotBeNull() {
        String[] invalidPriceFormats = {null, "", " ", "a"};

        for (String invalidPriceFormat : invalidPriceFormats) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceFormat)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage("Product price must not be null.");
        }
    }

    @Test
    public void productDiscountShouldNotBeLessThanZero() {
        String[] invalidPriceFormats = {"-1", "0"};

        for (String invalidPriceFormat : invalidPriceFormats) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceFormat)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage("Product price must not be 0 or less.");
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