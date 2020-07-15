package lv.sbogdano.javaguru.shoppinglist.service.validation.shoppingcart;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;
import lv.sbogdano.javaguru.shoppinglist.service.validation.shoppingcart.rule.ShoppingCartNameValidationRule;
import lv.sbogdano.javaguru.shoppinglist.service.validation.shoppingcart.rule.ShoppingCartValidationRule;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCartValidationService {

    private final Set<ShoppingCartValidationRule> validationRules = new HashSet<>();

    public ShoppingCartValidationService() {
        validationRules.add(new ShoppingCartNameValidationRule());
    }

    public void validate(ShoppingCart shoppingCart) {
        validationRules.forEach(rule -> rule.validate(shoppingCart));
    }

}
