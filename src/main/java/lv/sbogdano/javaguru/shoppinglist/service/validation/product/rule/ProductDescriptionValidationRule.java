package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (!descriptionIsValid(productDto.getDescription())) {
            throw new ItemValidationException(ProductValidationExceptionMessages.PRODUCT_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private boolean descriptionIsValid(String description) {
        return description != null && !description.isEmpty() && !description.isBlank();
    }
}
