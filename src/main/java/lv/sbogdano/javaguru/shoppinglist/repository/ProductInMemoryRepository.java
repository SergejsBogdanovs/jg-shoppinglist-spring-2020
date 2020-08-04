package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductInMemoryRepository implements ProductRepository {

    private final Map<Long, ProductEntity> inMemoryDB = new HashMap<>();
    private long productId = 0L;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        productEntity.setId(productId++);
        inMemoryDB.put(productEntity.getId(), productEntity);
        return productEntity;
    }

    @Override
    public Optional<ProductEntity> getProductById(long id) {
        return Optional.ofNullable(inMemoryDB.get(id));
    }

    @Override
    public Optional<ProductEntity> getProductByName(String name) {
        return inMemoryDB.values().stream()
                .filter(productEntity -> productEntity.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        inMemoryDB.replace(productEntity.getId(), productEntity);
        return productEntity;
    }

    @Override
    public Optional<ProductEntity> delete(long id) {
        return Optional.ofNullable(inMemoryDB.remove(id));
    }

}
