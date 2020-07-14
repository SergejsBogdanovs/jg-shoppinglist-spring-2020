package lv.sbogdano.javaguru.shoppinglist.service.validation.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (!priceIsValid(product.getPrice())) {
            throw new ProductValidationException("Product price must not be null or less than 0");
        }
    }

    private boolean priceIsValid(String price) {
        return isNumeric(price) && Double.parseDouble(price) > 0;
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
