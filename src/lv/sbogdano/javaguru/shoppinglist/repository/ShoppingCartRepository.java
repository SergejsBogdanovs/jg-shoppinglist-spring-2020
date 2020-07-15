package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;

public interface ShoppingCartRepository {

    ShoppingCart save(ShoppingCart shoppingCart);
}
