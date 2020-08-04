package lv.sbogdano.javaguru.shoppinglist.console;

import lv.sbogdano.javaguru.shoppinglist.console.action.ConsoleAction;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemNotFoundException;
import lv.sbogdano.javaguru.shoppinglist.service.validation.exception.ItemValidationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<ConsoleAction> consoleActions;

    public ConsoleUI(List<ConsoleAction> consoleActions) {
        this.consoleActions = consoleActions;
    }

    public void start() {

        var scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Please choose any option. \n");
                for (int i = 0; i < consoleActions.size(); i++) {
                    System.out.println(i + ". " + consoleActions.get(i));
                }

                int userInput = Integer.parseInt(scanner.nextLine());
                if (!isValid(userInput)) {
                    throw new IllegalArgumentException("Incorrect user input.");
                }

                consoleActions.get(userInput).execute();

            } catch (ItemNotFoundException | ItemValidationException exception ) {
                System.out.println(exception.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Price is incorrect.");
            } catch (Exception e) {
//                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }

    private boolean isValid(int userInput) {
        return userInput >= 0 && userInput < consoleActions.size();
    }
}
