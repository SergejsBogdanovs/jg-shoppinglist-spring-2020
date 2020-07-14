package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (!discountIsValid(product.getDiscount())) {
            throw new ProductValidationException("Product discount must not be null or less than 0");
        }
    }

    private boolean discountIsValid(String discount) {
        return isNumeric(discount) && Double.parseDouble(discount) >= 0 && Double.parseDouble(discount) <= 100;
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
