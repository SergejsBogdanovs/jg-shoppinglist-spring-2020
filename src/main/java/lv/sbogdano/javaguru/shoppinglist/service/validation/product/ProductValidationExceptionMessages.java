package lv.sbogdano.javaguru.shoppinglist.service.validation.product;

public interface ProductValidationExceptionMessages {

    String PRODUCT_NULL_EXCEPTION_MESSAGE = "Product must not be null.";

    String PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE = "Product not found. Id: ";

    String PRODUCT_CATEGORY_EMPTY_EXCEPTION_MESSAGE = "Product category must not be null or blank or empty.";

    String PRODUCT_NAME_EMPTY_EXCEPTION_MESSAGE = "Product name must not be null or blank or empty.";
    String PRODUCT_NAME_LENGTH_EXCEPTION_MESSAGE = "Product name length must be from 3 to 32 characters long.";
    String PRODUCT_NAME_UNIQUE_EXCEPTION_MESSAGE = "Product name already exist in DB. Please choose different product name.";

    String PRODUCT_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE = "Product description must not be null or blank or empty.";

    String PRODUCT_DISCOUNT_WRONG_FORMAT_EXCEPTION = "Wrong discount format. Please enter number between 0 and 100.";
    String PRODUCT_DISCOUNT_PRICE_IS_SMALL_EXCEPTION = "Can not make discount because price is less than $20.";

    String PRODUCT_PRICE_EMPTY_EXCEPTION_MESSAGE = "Product price must not be null.";
    String PRODUCT_PRICE_IS_ZERO_EXCEPTION_MESSAGE = "Product price must not be 0 or less.";

}
