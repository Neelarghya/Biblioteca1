package Biblioteca.contoller.commands;

import Biblioteca.common.Constants;
import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Title;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

// Action to check out a book from the Library
public class CheckOutBookCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Constants.ASK_CHECKOUT);
        String bookName = inputDriver.getInput();

        if (!library.contains(new Title(bookName))) {
            outputDriver.println("That book is not available.");
            return;
        }

        library.checkOut(new Title(bookName));
        outputDriver.println("Thank you! Enjoy the book");
    }
}
