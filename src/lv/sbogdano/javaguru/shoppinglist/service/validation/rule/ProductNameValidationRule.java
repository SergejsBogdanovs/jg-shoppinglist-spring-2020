package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (!nameIsValid(product.getName())) {
            throw new ProductValidationException("Product name must not be null or blank or empty");
        }
    }

    private boolean nameIsValid(String name) {
        return name != null && !name.isEmpty() && !name.isBlank() && name.length() >= 3 && name.length() <= 32;
    }
}
