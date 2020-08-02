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
public class ProductCategoryValidationRuleTest {

    @InjectMocks
    private ProductCategoryValidationRule victim;

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
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_CATEGORY_EMPTY_EXCEPTION_MESSAGE);
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