package lv.sbogdano.javaguru.shoppinglist.console.action;

import java.util.Scanner;

public interface ConsoleAction {

    void execute();

    default Scanner getScanner() {
        return new Scanner(System.in);
    }
}
