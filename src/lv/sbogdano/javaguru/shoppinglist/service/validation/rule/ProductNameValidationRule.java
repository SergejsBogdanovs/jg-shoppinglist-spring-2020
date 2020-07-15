package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

import java.util.HashSet;
import java.util.Set;

public class ProductNameValidationRule implements ProductValidationRule {

    private String message;
    private final Set<String> names = new HashSet<>();

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
        } else if (!names.add(name)) {
            message = "Product name already exist in DB. Please choose different product name.";
            return false;
        }
        return true;
    }
}
