package lv.sbogdano.javaguru.shoppinglist.console.action;

import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class DeleteProductByIdAction implements ConsoleAction {

    private final ProductService productService;

    public DeleteProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        var scanner = getScanner();

        System.out.println("Enter product id to delete:");
        long id = Long.parseLong(scanner.nextLine());
        var deletedProductDto = productService.deleteProduct(id);
        System.out.println("Product deleted: " + deletedProductDto);

    }

    @Override
    public String toString() {
        return "Delete product by id.";
    }
}
