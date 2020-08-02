package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {

    @InjectMocks
    private ProductPriceValidationRule victim;

    @Test
    public void productPriceShouldNotBeNull() {
        String[] invalidPriceFormats = {null, "", " ", "a"};

        for (String invalidPriceFormat : invalidPriceFormats) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceFormat)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_PRICE_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    @Test
    public void productDiscountShouldNotBeLessThanZero() {
        String[] invalidPriceFormats = {"-1", "0"};

        for (String invalidPriceFormat : invalidPriceFormats) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidPriceFormat)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_PRICE_IS_ZERO_EXCEPTION_MESSAGE);
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