package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;

public interface ProductValidationRule {

    void validate(ProductDto productDto);

}
