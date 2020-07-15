package lv.sbogdano.javaguru.shoppinglist.service;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;

public class ProductService {

    private final ProductRepository repository = new ProductInMemoryRepository();
    private final ProductValidationService validationService = new ProductValidationService();

    public Product save(Product product) {
        validationService.validate(product);
        return repository.save(product);
    }

    public Product findProductById(long id) {
        return repository.getProductById(id)
                .orElseThrow(() -> new ItemNotFoundException("Product not found. Id: " + id));
    }

    public Product updateProductById(Product product) {
        validationService.validate(product);
        return repository.update(product);
    }

    public Product deleteProduct(long id) {
        return repository.delete(id)
                .orElseThrow(() -> new ItemNotFoundException("Product not found. Id: " + id));
    }
}
