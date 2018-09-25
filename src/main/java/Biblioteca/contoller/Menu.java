package Biblioteca.contoller;

import Biblioteca.contoller.commands.*;
import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

// Actions that can be performed by user
public enum Menu {
    QUIT("Quit", new QuitCommand()),
    LIST_BOOKS("List Books", new ListBooksCommand()),
    CHECK_OUT("Check Out a book", new CheckOutBookCommand()),
    RETURN("Return a book", new ReturnBookCommand()),
    INVALID_OPTION("", new InvalidOptionCommand());

    private final String display;
    private final Command command;

    Menu(String display, Command command) {
        this.display = "Enter " + ordinal() + " to " + display;
        this.command = command;
    }

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        command.perform(library, outputDriver, inputDriver);
    }

    public String getMenu() {
        return display;
    }
}
