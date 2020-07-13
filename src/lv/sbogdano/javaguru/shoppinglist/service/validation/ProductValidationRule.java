package lv.sbogdano.javaguru.shoppinglist.service.validation;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

public class ProductValidationRule {

//    public void validate(Product product) {
//
//        if (product.getName() == null || product.getName().isEmpty() || product.getName().isBlank()) {
//            throw new ProductValidationException("Product name must not be null or blank or empty");
//        } else if (product.getCategory() == null || product.getCategory().isEmpty() || product.getCategory().isBlank()) {
//            throw new ProductValidationException("Product category must not be null or blank or empty");
//        } else if (product.getDescription() == null || product.getDescription().isEmpty() || product.getDescription().isBlank()) {
//            throw new ProductValidationException("Product description must not be null or blank or empty");
//        } else if (product.getPrice() == null || product.getPrice() <= 0) {
//            throw new ProductValidationException("Product price must not be null or less than 0");
//        } else if (product.getDiscount() == null || product.getDiscount() < 0) {
//            throw new ProductValidationException("Product discount must not be null or less than 0");
//        }
//    }
}
