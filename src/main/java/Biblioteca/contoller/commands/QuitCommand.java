package Biblioteca.contoller.commands;

import Biblioteca.common.Constants;
import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

// Action to exit from the system
public class QuitCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.println(Constants.QUIT_MESSAGE);
    }
}
