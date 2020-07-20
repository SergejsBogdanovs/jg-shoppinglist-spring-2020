package lv.sbogdano.javaguru.shoppinglist.console;

import lv.sbogdano.javaguru.shoppinglist.dto.ProductDto;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;

import java.util.Scanner;

public class ConsoleUI {

    private final ProductService productService = new ProductService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            try {
                System.out.println("1. Create product.");
                System.out.println("2. Find product by id.");
                System.out.println("3. Update product by id.");
                System.out.println("4. Delete product by id.");
                System.out.println("5. Exit.");

                int userInput = Integer.valueOf(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProductById();
                        break;
                    case 3:
                        updateProductById();
                        break;
                    case 4:
                        deleteProductById();
                        break;
                    case 5:
                        return;
                }
            } catch (ItemNotFoundException | ItemValidationException exception ) {
                System.out.println(exception.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Price is incorrect.");
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createProduct() {
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

    private void findProductById() {
        System.out.println("Enter product id:");
        long id = Long.parseLong(scanner.nextLine());
        var foundProductDto = productService.findProductById(id);
        System.out.println("Product found: " + foundProductDto);
    }

    private void updateProductById() {
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

    private void deleteProductById() {
        System.out.println("Enter product id to delete:");
        long id = Long.parseLong(scanner.nextLine());
        var deletedProductDto = productService.deleteProduct(id);
        System.out.println("Product deleted: " + deletedProductDto);
    }
}
