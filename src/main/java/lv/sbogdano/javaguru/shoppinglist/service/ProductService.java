package lv.sbogdano.javaguru.shoppinglist.service;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.mapper.BeanMapper;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;

public class ProductService {

    private ProductRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService(repository);
    private BeanMapper beanMapper = new BeanMapper();

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity savedProductEntity = repository.save(beanMapper.toProductEntity(productDto));
        return beanMapper.toProductDto(savedProductEntity);
    }

    public ProductDto findProductById(long id) {
        ProductEntity foundProductEntity = repository.getProductById(id)
                .orElseThrow(() -> new ItemNotFoundException("Product not found. Id: " + id));
        return beanMapper.toProductDto(foundProductEntity);
    }

    public ProductDto updateProductById(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity updateProductEntity = repository.update(beanMapper.toProductEntity(productDto));
        return beanMapper.toProductDto(updateProductEntity);
    }

    public ProductDto deleteProduct(long id) {
        ProductEntity deletedProductEntity = repository.delete(id)
                .orElseThrow(() -> new ItemNotFoundException("Product not found. Id: " + id));
        return beanMapper.toProductDto(deletedProductEntity);
    }
}
