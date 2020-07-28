package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidCategory)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage("Product category must not be null or blank or empty.");
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