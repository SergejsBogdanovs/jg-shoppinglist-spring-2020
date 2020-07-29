package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ProductNameValidationRule implements ProductValidationRule {

    private String message;
    private final ProductRepository repository;

    public ProductNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDto productDto) {
        if (!nameIsValid(productDto)) {
            throw new ItemValidationException(message);
        }
    }

    private boolean nameIsValid(ProductDto productDto) {
        if (productDto.getName() == null || productDto.getName().isEmpty() || productDto.getName().isBlank()) {
            message = "Product name must not be null or blank or empty.";
            return false;
        } else if (productDto.getName().length() < 3 || productDto.getName().length() > 32) {
            message = "Product name length must be from 3 to 32 characters long.";
            return false;
        } else if (nameExist(productDto)) {
            message = "Product name already exist in DB. Please choose different product name.";
            return false;
        }
        return true;
    }

    private boolean nameExist(ProductDto productDto) {
        return repository.getProductByName(productDto.getName()).isPresent();
    }
}
