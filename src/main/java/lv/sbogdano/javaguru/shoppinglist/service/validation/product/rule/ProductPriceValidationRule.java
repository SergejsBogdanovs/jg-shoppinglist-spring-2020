package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.springframework.stereotype.Component;

@Component
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
            message = ProductValidationExceptionMessages.PRODUCT_PRICE_EMPTY_EXCEPTION_MESSAGE;
            return false;
        } else if (Double.parseDouble(price) <= 0) {
            message = ProductValidationExceptionMessages.PRODUCT_PRICE_IS_ZERO_EXCEPTION_MESSAGE;
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
