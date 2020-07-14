package lv.sbogdano.javaguru.shoppinglist.service.validation;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.rule.*;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductDescriptionValidationRule());
        validationRules.add(new ProductCategoryValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(rule -> rule.validate(product));
    }

}
