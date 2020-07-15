package lv.sbogdano.javaguru.shoppinglist.service.validation.shoppingcart.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ShoppingCartNameValidationRule implements ShoppingCartValidationRule {

    @Override
    public void validate(ShoppingCart shoppingCart) {
        if (shoppingCart.getName() == null || shoppingCart.getName().isBlank() || shoppingCart.getName().isEmpty()) {
            throw new ItemValidationException("Shopping cart name must not be null or blank or empty");
        }
    }
}
