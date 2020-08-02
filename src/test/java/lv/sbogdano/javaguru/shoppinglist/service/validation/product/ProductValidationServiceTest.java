package lv.sbogdano.javaguru.shoppinglist.service.validation.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@RunWith(MockitoJUnitRunner.class)
public class ProductValidationServiceTest {

    @InjectMocks
    private ProductValidationService victim;

    @Test
    public void shouldThrowExceptionWhenProductIsNull() {
        assertThatThrownBy(() -> victim.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ProductValidationExceptionMessages.PRODUCT_NULL_EXCEPTION_MESSAGE);
    }
}