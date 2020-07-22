package lv.sbogdano.javaguru.shoppinglist.mapper;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanMapperTest {

    private final BeanMapper victim = new BeanMapper();

    @Test
    public void toProductDto() {
        var productDto = victim.toProductDto(entity());
        assertEquals(dto(), productDto);
    }

    @Test
    public void toProductEntity() {
        var productEntity = victim.toProductEntity(dto());
        assertEquals(entity(), productEntity);
    }

    private ProductDto dto() {
        var productDto = new ProductDto();
        productDto.setId(0L);
        productDto.setName("name");
        productDto.setDescription("description");
        productDto.setPrice("100");
        productDto.setDiscount("10");
        productDto.setCategory("category");

        return productDto;
    }

    private ProductEntity entity() {
        var productEntity = new ProductEntity();
        productEntity.setId(0L);
        productEntity.setName("name");
        productEntity.setDescription("description");
        productEntity.setPrice("100");
        productEntity.setDiscount("10");
        productEntity.setCategory("category");

        return productEntity;
    }
}