package lv.sbogdano.javaguru.shoppinglist.service.validation;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

public class ProductValidationService {

    private ProductValidationRule validationRule = new ProductValidationRule();

    public void validate(Product product) {
        validationRule.validate(product);
    }
}
