package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (!descriptionIsValid(product.getDescription())) {
            throw new ProductValidationException("Product description must not be null or blank or empty");
        }
    }

    private boolean descriptionIsValid(String description) {
        return description != null && !description.isEmpty() && !description.isBlank();
    }
}
