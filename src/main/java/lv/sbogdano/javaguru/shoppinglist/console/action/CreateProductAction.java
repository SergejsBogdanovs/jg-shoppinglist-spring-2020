package lv.sbogdano.javaguru.shoppinglist.console.action;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class CreateProductAction implements ConsoleAction {

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        var scanner = getScanner();

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        System.out.println("Enter product price:");
        String price = scanner.nextLine();
        System.out.println("Enter product discount:");
        String discount = scanner.nextLine();
        System.out.println("Enter product category:");
        String category = scanner.nextLine();

        var productDto = new ProductDto();
        productDto.setName(name);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setDiscount(discount);
        productDto.setCategory(category);

        ProductDto createdProductDto = productService.save(productDto);
        System.out.println("Product successfully created: Product id " + createdProductDto);
    }

    @Override
    public String toString() {
        return "Create product.";
    }
}
