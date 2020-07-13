package lv.sbogdano.javaguru.shoppinglist.repository;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> getProductById(Long id);

    Product update(Product product);
}
