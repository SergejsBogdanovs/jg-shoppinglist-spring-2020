package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ProductCategoryValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (!categoryIsValid(productDto.getCategory())) {
            throw new ItemValidationException("Product category must not be null or blank or empty");
        }
    }

    private boolean categoryIsValid(String category) {
        return category != null && !category.isEmpty() && !category.isBlank();
    }
}
