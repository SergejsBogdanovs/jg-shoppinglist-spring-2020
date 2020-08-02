package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductNameValidationRule victim;

    @Test
    public void productNameShouldNotBeEmpty() {
        String[] invalidNames = {
                null,
                "",
                " "
        };

        for (String invalidName : invalidNames) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidName)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    @Test
    public void productNameShouldNotBeToShortOrToLong() {
        String[] invalidNames = {
                "a",
                new String((new char[33])).replace('\0', 'a')
        };

        for (String invalidName : invalidNames) {
            assertThatThrownBy(() -> victim.validate(getProductDto(invalidName)))
                    .isInstanceOf(ItemValidationException.class)
                    .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Test
    public void productNameShouldNotContainDuplicates() {

        when(productRepository.getProductByName("NAME")).thenReturn(Optional.of(productEntity()));

        assertThatThrownBy(() -> victim.validate(getProductDto("NAME")))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_UNIQUE_EXCEPTION_MESSAGE);
    }

    private ProductDto getProductDto(String name) {
        var productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName(name);
        productDto.setDescription("DESCRIPTION");
        productDto.setPrice("PRICE");
        productDto.setDiscount("DISCOUNT");
        productDto.setCategory("CATEGORY");

        return productDto;
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


}