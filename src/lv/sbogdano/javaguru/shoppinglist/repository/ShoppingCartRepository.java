package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartRepository {

    ShoppingCart save(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getShoppingCartById(long id);
}
