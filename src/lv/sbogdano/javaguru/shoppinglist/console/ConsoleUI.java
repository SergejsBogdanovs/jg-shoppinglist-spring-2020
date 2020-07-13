package lv.sbogdano.javaguru.shoppinglist.console;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            try {
                System.out.println("1. Create product.");
                System.out.println("2. Find product by id.");
                System.out.println("3. Update product by id.");
                System.out.println("4. Exit.");

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
                        return;
                }
            } catch (ProductNotFoundException | ProductValidationException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception e) {
                System.out.println("Error! Please try again");
            }

        }
    }

    private void createProduct() {
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        System.out.println("Enter product price:");
        //Double price = Double.valueOf(scanner.nextLine());
        String price = scanner.nextLine();
        System.out.println("Enter product discount:");
        //Double discount = Double.valueOf(scanner.nextLine());
        String discount = scanner.nextLine();
        System.out.println("Enter product category:");
        String category = scanner.nextLine();

        var product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setCategory(category);

        Product createdProduct = productService.save(product);
        System.out.println("Product successfully created: Product id " + createdProduct);
    }

    private void findProductById() {
        System.out.println("Enter product id:");
        long id = Long.parseLong(scanner.nextLine());
        var product = productService.findProductById(id);
        System.out.println("Product found: " + product);
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
        //Double price = Double.valueOf(scanner.nextLine());
        String newPrice = scanner.nextLine();
        System.out.println("Enter new product discount:");
        //Double discount = Double.valueOf(scanner.nextLine());
        String newDiscount = scanner.nextLine();
        System.out.println("Enter new product category:");
        String newCategory = scanner.nextLine();

        var product = new Product();
        product.setId(foundProduct.getId());
        product.setName(newName);
        product.setDescription(newDescription);
        product.setPrice(newPrice);
        product.setDiscount(newDiscount);
        product.setCategory(newCategory);

        var updatedProduct = productService.updateProductById(product);
        System.out.println("Product successfully updated: Product id " + updatedProduct);
    }
}
