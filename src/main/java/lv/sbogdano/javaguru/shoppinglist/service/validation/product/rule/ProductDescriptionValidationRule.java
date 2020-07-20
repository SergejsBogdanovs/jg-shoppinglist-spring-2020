package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (!descriptionIsValid(productDto.getDescription())) {
            throw new ItemValidationException("Product description must not be null or blank or empty");
        }
    }

    private boolean descriptionIsValid(String description) {
        return description != null && !description.isEmpty() && !description.isBlank();
    }
}
