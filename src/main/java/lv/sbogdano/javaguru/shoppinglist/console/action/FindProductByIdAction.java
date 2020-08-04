package lv.sbogdano.javaguru.shoppinglist.console.action;

import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FindProductByIdAction implements ConsoleAction {

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        var scanner = getScanner();

        System.out.println("Enter product id:");
        long id = Long.parseLong(scanner.nextLine());
        var foundProductDto = productService.findProductById(id);
        System.out.println("Product found: " + foundProductDto);

    }

    @Override
    public String toString() {
        return "Find product by id.";
    }
}
