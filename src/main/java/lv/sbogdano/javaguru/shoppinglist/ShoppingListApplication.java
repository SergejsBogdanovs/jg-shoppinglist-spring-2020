package lv.sbogdano.javaguru.shoppinglist;

import lv.sbogdano.javaguru.shoppinglist.console.ConsoleUI;
import lv.sbogdano.javaguru.shoppinglist.mapper.BeanMapper;
import lv.sbogdano.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.ProductValidationService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.product.rule.*;

import java.util.HashSet;
import java.util.Set;

public class ShoppingListApplication {

    public static void main(String[] args) {

        var beenMapper = new BeanMapper();
        var productRepository =  new ProductInMemoryRepository();

        Set<ProductValidationRule> productValidationRules = new HashSet<>();
        productValidationRules.add(new ProductNameValidationRule(productRepository));
        productValidationRules.add(new ProductDescriptionValidationRule());
        productValidationRules.add(new ProductPriceValidationRule());
        productValidationRules.add(new ProductDiscountValidationRule());
        productValidationRules.add(new ProductCategoryValidationRule());

        var productValidationService = new ProductValidationService(productValidationRules);

        var productService = new ProductService(productRepository, productValidationService, beenMapper);

        var consoleUI = new ConsoleUI(productService);
        consoleUI.start();
    }
}
