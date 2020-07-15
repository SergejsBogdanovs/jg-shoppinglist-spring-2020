package lv.sbogdano.javaguru.shoppinglist.service;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;
import lv.sbogdano.javaguru.shoppinglist.repository.ShoppingCartInMemoryRepository;
import lv.sbogdano.javaguru.shoppinglist.repository.ShoppingCartRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.shoppingcart.ShoppingCartValidationService;

public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository = new ShoppingCartInMemoryRepository();
    private final ShoppingCartValidationService validationService = new ShoppingCartValidationService();

    public ShoppingCart save(ShoppingCart shoppingCart) {
        validationService.validate(shoppingCart);
        return shoppingCartRepository.save(shoppingCart);
    }
}
