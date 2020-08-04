package lv.sbogdano.javaguru.shoppinglist.console.action;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class ExitAction implements ConsoleAction {
    @Override
    public void execute() {
        System.out.println("Goodbye.");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit.";
    }
}
