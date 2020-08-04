package lv.sbogdano.javaguru.shoppinglist.service.validation.product;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule.ProductValidationRule;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(ProductDto productDto) {
        if (productDto == null) throw new IllegalArgumentException(
                ProductValidationExceptionMessages.PRODUCT_NULL_EXCEPTION_MESSAGE);
        validationRules.forEach(rule -> rule.validate(productDto));
    }

}
