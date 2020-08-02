package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;

public class ProductCategoryValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (!categoryIsValid(productDto.getCategory())) {
            throw new ItemValidationException(ProductValidationExceptionMessages.PRODUCT_CATEGORY_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private boolean categoryIsValid(String category) {
        return category != null && !category.isEmpty() && !category.isBlank();
    }
}
