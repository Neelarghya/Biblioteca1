package Biblioteca.contoller.commands;

import Biblioteca.common.Constants;
import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Title;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

// Action to return a book from the Library that was previously checked out
public class ReturnBookCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Constants.ASK_RETURN);
        String bookName = inputDriver.getInput();

        if (!library.hasCheckedOut(new Title(bookName))) {
            outputDriver.println("That is not a valid book to return.");
            return;
        }

        library.returnBook(new Title(bookName));
        outputDriver.println("Thank you for returning the book.");
    }
}
