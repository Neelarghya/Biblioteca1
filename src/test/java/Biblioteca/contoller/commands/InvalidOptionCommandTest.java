package Biblioteca.contoller.commands;

import Biblioteca.contoller.Menu;
import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InvalidOptionCommandTest {
    private Command command = new InvalidOptionCommand();
    private Library library = mock(Library.class);
    private OutputDriver outputDriver = mock(OutputDriver.class);
    private InputDriver inputDriver = mock(InputDriver.class);

    @DisplayName("Should display 'Select a valid option!' for INVALID OPTION")
    @Test
    void testPerformInvalidOption() {
        command.perform(library, outputDriver, inputDriver);
        verify(outputDriver).println("Select a valid option!");
    }
}