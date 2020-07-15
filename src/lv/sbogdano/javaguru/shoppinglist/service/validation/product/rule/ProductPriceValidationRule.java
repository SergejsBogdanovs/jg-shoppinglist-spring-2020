package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ProductPriceValidationRule implements ProductValidationRule {

    private String message;

    @Override
    public void validate(Product product) {
        if (!priceIsValid(product.getPrice())) {
            throw new ItemValidationException(message);
        }
    }

    private boolean priceIsValid(String price) {
        if (!isNumeric(price)) {
            message = "Product price must not be null";
            return false;
        } else if (Double.parseDouble(price) <= 0) {
            message = "Product price must not be less than 0";
            return false;
        }
        return true;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
