package lv.sbogdano.javaguru.shoppinglist.console.action;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class UpdateProductByIdAction implements ConsoleAction {

    private final ProductService productService;

    public UpdateProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        var scanner = getScanner();

        System.out.println("Enter product id to update:");
        long id = Long.parseLong(scanner.nextLine());
        var foundProduct = productService.findProductById(id);
        System.out.println("Product found: " + foundProduct);

        System.out.println("Enter new product name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new product description:");
        String newDescription = scanner.nextLine();
        System.out.println("Enter new product price:");
        String newPrice = scanner.nextLine();
        System.out.println("Enter new product discount:");
        String newDiscount = scanner.nextLine();
        System.out.println("Enter new product category:");
        String newCategory = scanner.nextLine();

        var newProductDto = new ProductDto();
        newProductDto.setId(foundProduct.getId());
        newProductDto.setName(newName);
        newProductDto.setDescription(newDescription);
        newProductDto.setPrice(newPrice);
        newProductDto.setDiscount(newDiscount);
        newProductDto.setCategory(newCategory);

        var updatedProductDto = productService.updateProductById(newProductDto);
        System.out.println("Product successfully updated: Product " + updatedProductDto);
    }

    @Override
    public String toString() {
        return "Update product by id.";
    }
}
