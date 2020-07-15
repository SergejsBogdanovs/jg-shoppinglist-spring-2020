package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

}
