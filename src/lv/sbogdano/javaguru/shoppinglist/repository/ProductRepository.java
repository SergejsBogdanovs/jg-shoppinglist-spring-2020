package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> getProductById(long id);

    Product update(Product product);

    Optional<Product> delete(long id);
}
