package Biblioteca.contoller;

import Biblioteca.common.Constants;
import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//System to manage a library
public class LibraryManagementSystem {
    private final OutputDriver outputDriver;
    private final InputDriver inputDriver;
    private final Library library;

    public LibraryManagementSystem(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        this.outputDriver = outputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
    }

    public void start() {
        outputDriver.println(Constants.WELCOME_CUSTOMER_MESSAGE);
        runMenu();
    }

    private void runMenu() {
        Menu menu;
        do {
            displayMenu();
            outputDriver.print("Enter your Choice: ");
            final int option = inputDriver.getIntInput();

            if (!isValidOption(option)) {
                menu = Menu.INVALID_OPTION;
            } else {
                menu = Menu.values()[option];
            }
            menu.perform(library, outputDriver, inputDriver);
            outputDriver.printDivider();
        } while (menu != Menu.QUIT);
    }

    private boolean isValidOption(final int option) {
        List<Integer> allValidOptions = Arrays.stream(Menu.values())
                .map(Enum::ordinal)
                .collect(Collectors.toList());
        return allValidOptions.contains(option);
    }

    private void displayMenu() {
        for (Menu menu : Menu.values()) {
            if (menu != Menu.QUIT && menu != Menu.INVALID_OPTION) {
                outputDriver.println(menu.getMenu());
            }
        }

        outputDriver.println(Menu.QUIT.getMenu());
    }
}
