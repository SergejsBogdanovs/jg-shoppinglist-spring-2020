package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ProductPriceValidationRule implements ProductValidationRule {

    private String message;

    @Override
    public void validate(ProductDto productDto) {
        if (!priceIsValid(productDto.getPrice())) {
            throw new ItemValidationException(message);
        }
    }

    private boolean priceIsValid(String price) {
        if (!isNumeric(price)) {
            message = "Product price must not be null.";
            return false;
        } else if (Double.parseDouble(price) <= 0) {
            message = "Product price must not be 0 or less.";
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
