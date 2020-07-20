package lv.sbogdano.javaguru.shoppinglist.service.validation.product;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule.*;

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

    public void validate(ProductDto productDto) {
        validationRules.forEach(rule -> rule.validate(productDto));
    }

}
