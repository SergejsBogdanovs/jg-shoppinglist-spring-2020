package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductNameValidationRule implements ProductValidationRule {

    private String message;

    @Override
    public void validate(Product product) {
        if (!nameIsValid(product.getName())) {
            throw new ProductValidationException(message);
        }
    }

    private boolean nameIsValid(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            message = "Product name must not be null or blank or empty";
            return false;
        } else if (name.length() < 3 || name.length() > 32) {
            message = "Product name length must be from 3 to 32 characters long.";
            return false;
        }
        return true;
    }
}
