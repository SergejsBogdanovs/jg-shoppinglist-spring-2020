package lv.sbogdano.javaguru.shoppinglist.service;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.mapper.BeanMapper;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationService;

public class ProductService {

    private final ProductRepository repository;
    private final ProductValidationService validationService;
    private final BeanMapper beanMapper;

    public ProductService(ProductRepository repository,
                          ProductValidationService validationService,
                          BeanMapper beanMapper) {
        this.repository = repository;
        this.validationService = validationService;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity savedProductEntity = repository.save(beanMapper.toProductEntity(productDto));
        return beanMapper.toProductDto(savedProductEntity);
    }

    public ProductDto findProductById(long id) {
        ProductEntity foundProductEntity = repository.getProductById(id)
                .orElseThrow(() -> new ItemNotFoundException(
                        ProductValidationExceptionMessages.PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE + id));
        return beanMapper.toProductDto(foundProductEntity);
    }

    public ProductDto updateProductById(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity updateProductEntity = repository.update(beanMapper.toProductEntity(productDto));
        return beanMapper.toProductDto(updateProductEntity);
    }

    public ProductDto deleteProduct(long id) {
        ProductEntity deletedProductEntity = repository.delete(id)
                .orElseThrow(() -> new ItemNotFoundException(
                        ProductValidationExceptionMessages.PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE + id));
        return beanMapper.toProductDto(deletedProductEntity);
    }
}
