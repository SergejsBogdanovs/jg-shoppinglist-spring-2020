package lv.sbogdano.javaguru.shoppinglist;

import lv.sbogdano.javaguru.shoppinglist.config.AppConfig;
import lv.sbogdano.javaguru.shoppinglist.console.ConsoleUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(ConsoleUI.class).start();
    }
}
