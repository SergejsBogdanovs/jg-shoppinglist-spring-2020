package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;

import java.util.Optional;

public interface ProductRepository {

    ProductEntity save(ProductEntity productEntity);

    Optional<ProductEntity> getProductById(long id);

    Optional<ProductEntity> getProductByName(String name);

    ProductEntity update(ProductEntity productEntity);

    Optional<ProductEntity> delete(long id);
}
