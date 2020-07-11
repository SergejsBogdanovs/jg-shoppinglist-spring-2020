package lv.sbogdano.javaguru.shoppinglist.service.validation.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
