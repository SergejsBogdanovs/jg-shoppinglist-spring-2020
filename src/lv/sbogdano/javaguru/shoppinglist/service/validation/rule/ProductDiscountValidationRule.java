package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private String message;

    @Override
    public void validate(Product product) {
        if (!discountIsValid(product)) {
            throw new ProductValidationException(message);
        }
    }

    private boolean discountIsValid(Product product) {
        if (!isNumeric(product.getDiscount()) ||
                Double.parseDouble(product.getDiscount()) < 0 ||
                Double.parseDouble(product.getDiscount()) > 100) {
            message = "Wrong discount format. Please enter number between 0 and 100";
            return false;
        } else if (Double.parseDouble(product.getPrice()) < 20) {
            message = "Can not make discount because price is less than $20";
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
