package lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lv.sbogdano.javaguru.shoppinglist.domain.ProductEntity;
import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductRepository;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationExceptionMessages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class ProductNameValidationRuleTest {

    private static final long ID = 1L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PRICE = "PRICE";
    private static final String DISCOUNT = "DISCOUNT";
    private static final String CATEGORY = "CATEGORY";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductNameValidationRule victim;

    private static final Object[] getInvalidNames() {
        return new String[][]{{null}, {""}, {" "}};
    }

    private static final Object[] getInvalidNameLengths() {
        return new String[][]{{"a"}, {new String((new char[33])).replace('\0', 'a')}};
    }

    @Test
    @Parameters(method = "getInvalidNames")
    public void shouldThrowIVEForInvalidName(String invalidName) {
        assertThatThrownBy(() -> victim.validate(getProductDto(invalidName)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_EMPTY_EXCEPTION_MESSAGE);
    }

    @Test
    @Parameters(method = "getInvalidNameLengths")
    public void shouldThrowIVEForTooShortAndTooLongName(String invalidNameLength) {
        assertThatThrownBy(() -> victim.validate(getProductDto(invalidNameLength)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    public void shouldThrowIVEWhenNameNotUnique() {

        when(productRepository.getProductByName(NAME)).thenReturn(Optional.of(getProductEntity()));

        assertThatThrownBy(() -> victim.validate(getProductDto(NAME)))
                .isInstanceOf(ItemValidationException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NAME_UNIQUE_EXCEPTION_MESSAGE);
    }

    private ProductDto getProductDto(String invalidName) {
        var productDto = new ProductDto();
        productDto.setId(ID);
        productDto.setName(invalidName);
        productDto.setDescription(DESCRIPTION);
        productDto.setPrice(PRICE);
        productDto.setDiscount(DISCOUNT);
        productDto.setCategory(CATEGORY);

        return productDto;
    }

    private ProductEntity getProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(ID);
        productEntity.setName(NAME);
        productEntity.setDescription(DESCRIPTION);
        productEntity.setPrice(PRICE);
        productEntity.setDiscount(DISCOUNT);
        productEntity.setCategory(CATEGORY);

        return productEntity;
    }
}