package lv.sbogdano.javaguru.shoppinglist.console;

import lv.sbogdano.javaguru.shoppinglist.domain.Product;
import lv.sbogdano.javaguru.shoppinglist.service.ProductService;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ProductValidationException;

import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();

    public void start() {

        var scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("1. Create product.");
                System.out.println("2. Find product by id.");
                System.out.println("3. Exit.");

                int userInput = Integer.valueOf(scanner.nextLine());

                switch (userInput) {
                    case 1:
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

                        var product = new Product.Builder()
                                .name(name)
                                .description(description)
                                .price(price)
                                .discount(discount)
                                .category(category)
                                .build();

                        Product createdProduct = productService.save(product);
                        System.out.println("Product successfully created: Product id " + createdProduct);
                        break;

                    case 2:
                        System.out.println("Enter product id:");
                        long id = Long.parseLong(scanner.nextLine());
                        var product1 = productService.findProductById(id);
                        System.out.println("Product found: " + product1);
                        break;

                    case 3:
                        return;
                }
            } catch (ProductNotFoundException | ProductValidationException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception e) {
                System.out.println("Error! Please try again");
            }

        }
    }
}
