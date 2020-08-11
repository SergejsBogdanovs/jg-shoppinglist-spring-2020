package lv.sbogdano.javaguru.shoppinglist.mapper;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeanMapperTest {

    private static final long ID = 0L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PRICE = "PRICE";
    private static final String DISCOUNT = "DISCOUNT";
    private static final String CATEGORY = "CATEGORY";

    private final BeanMapper victim = new BeanMapper();

    @Test
    public void toProductDto() {
        var productDto = victim.toProductDto(getProductEntity());
        assertEquals(getProductDto(), productDto);
    }

    @Test
    public void toProductEntity() {
        var productEntity = victim.toProductEntity(getProductDto());
        assertEquals(getProductEntity(), productEntity);
    }

    private ProductDto getProductDto() {
        var productDto = new ProductDto();
        productDto.setId(ID);
        productDto.setName(NAME);
        productDto.setDescription(DESCRIPTION);
        productDto.setPrice(PRICE);
        productDto.setDiscount(DISCOUNT);
        productDto.setCategory(CATEGORY);

        return productDto;
    }

    private ProductEntity getProductEntity() {
        var productEntity = new ProductEntity();
        productEntity.setId(ID);
        productEntity.setName(NAME);
        productEntity.setDescription(DESCRIPTION);
        productEntity.setPrice(PRICE);
        productEntity.setDiscount(DISCOUNT);
        productEntity.setCategory(CATEGORY);

        return productEntity;
    }
}