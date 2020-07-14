package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

}
