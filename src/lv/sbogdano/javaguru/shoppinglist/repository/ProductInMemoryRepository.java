package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, Product> repository = new HashMap<>();
    private long productId = 0L;

    @Override
    public Product save(Product product) {
        product.setId(productId++);
        repository.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Product update(Product product) {
        repository.replace(product.getId(), product);
        return product;
    }
}
