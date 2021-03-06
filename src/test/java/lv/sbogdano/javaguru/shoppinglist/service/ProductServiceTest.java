package lv.sbogdano.javaguru.shoppinglist.service;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.mapper.BeanMapper;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductValidationService productValidationService;
    @Mock
    private BeanMapper beanMapper;

    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldSaveProduct() {
        when(productRepository.save(any())).thenReturn(productEntity());
        when(beanMapper.toProductDto(productEntity())).thenReturn(productDto());

        ProductDto savedProductDto = victim.save(productDto());

        verify(productValidationService).validate(any());

        assertThat(savedProductDto).isEqualTo(productDto());
    }

    @Test
    public void shouldFindProductById() {
        when(productRepository.getProductById(anyLong())).thenReturn(Optional.of(productEntity()));
        when(beanMapper.toProductDto(productEntity())).thenReturn(productDto());

        ProductDto foundProduct = victim.findProductById(1L);

        assertThat(foundProduct).isEqualTo(productDto());
    }

    @Test
    public void shouldThrowItemNotFoundException() {
        when(productRepository.getProductById(anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> victim.findProductById(1L))
                .isInstanceOf(ItemNotFoundException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE + 1);
    }

    @Test
    public void shouldUpdateProductById() {
        when(productRepository.update(any())).thenReturn(productEntity());
        when(beanMapper.toProductDto(productEntity())).thenReturn(productDto());

        ProductDto replacedProduct = victim.updateProductById(productDto());

        verify(productValidationService).validate(any());
        assertThat(replacedProduct).isEqualTo(productDto());
    }

    @Test
    public void shouldDeleteProduct() {
        when(productRepository.delete(anyLong())).thenReturn(Optional.of(productEntity()));
        when(beanMapper.toProductDto(productEntity())).thenReturn(productDto());

        ProductDto deletedProduct = victim.deleteProduct(1L);

        assertThat(deletedProduct).isEqualTo(productDto());
    }

    private ProductEntity productEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1L);
        productEntity.setName("NAME");
        productEntity.setDescription("DESCRIPTION");
        productEntity.setPrice("PRICE");
        productEntity.setDiscount("DISCOUNT");
        productEntity.setCategory("CATEGORY");
        return productEntity;
    }

    private ProductDto productDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("NAME");
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice("PRICE");
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory("CATEGORY");
        return productDto;
    }

}