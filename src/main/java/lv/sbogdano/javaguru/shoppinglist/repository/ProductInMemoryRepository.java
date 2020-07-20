package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, Product> inMemoryDB = new HashMap<>();
    private long productId = 0L;

    @Override
    public Product save(Product product) {
        product.setId(productId++);
        inMemoryDB.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(inMemoryDB.get(id));
    }

    @Override
    public Product update(Product product) {
        inMemoryDB.replace(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> delete(long id) {
        return Optional.ofNullable(inMemoryDB.remove(id));
    }

}
