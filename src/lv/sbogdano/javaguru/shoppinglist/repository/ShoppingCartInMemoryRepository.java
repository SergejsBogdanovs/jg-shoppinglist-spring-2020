package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShoppingCartInMemoryRepository implements ShoppingCartRepository {

    private final Map<Long, ShoppingCart> inMemoryDb = new HashMap<>();
    private long id = 0L;

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        shoppingCart.setId(id++);
        inMemoryDb.put(shoppingCart.getId(), shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> getShoppingCartById(long id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }
}
