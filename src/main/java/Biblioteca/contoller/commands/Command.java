package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

public interface Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver);
}
