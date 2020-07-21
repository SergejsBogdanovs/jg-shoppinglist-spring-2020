package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private String message;

    @Override
    public void validate(ProductDto productDto) {
        if (!discountIsValid(productDto)) {
            throw new ItemValidationException(message);
        }
    }

    private boolean discountIsValid(ProductDto productDto) {
        if (!isNumeric(productDto.getDiscount()) ||
                Double.parseDouble(productDto.getDiscount()) < 0 ||
                Double.parseDouble(productDto.getDiscount()) > 100) {
            message = "Wrong discount format. Please enter number between 0 and 100";
            return false;
        } else if (Double.parseDouble(productDto.getPrice()) < 20 && Double.parseDouble(productDto.getDiscount()) > 0) {
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
