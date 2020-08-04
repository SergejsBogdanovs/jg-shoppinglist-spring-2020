package lv.sbogdano.javaguru.shoppinglist.mapper;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class BeanMapper {

    public ProductDto toProductDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setDescription(productEntity.getDescription());
        productDto.setPrice(productEntity.getPrice());
        productDto.setDiscount(productEntity.getDiscount());
        productDto.setCategory(productEntity.getCategory());
        return productDto;
    }

    public ProductEntity toProductEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setDiscount(productDto.getDiscount());
        productEntity.setCategory(productDto.getCategory());
        return productEntity;
    }

}
