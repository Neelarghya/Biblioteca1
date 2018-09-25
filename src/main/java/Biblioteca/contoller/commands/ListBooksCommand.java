package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

import static Biblioteca.common.Constants.NUMBER_OF_COLUMNS_IN_BOOK_DETAILS;

// Action to display all the available books in the library
public class ListBooksCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.printInColumns(library.getBookDetails(), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }
}
