package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitCommandTest {
    private Command quit = new QuitCommand();
    private Library library = mock(Library.class);
    private OutputDriver outputDriver = mock(OutputDriver.class);
    private InputDriver inputDriver = mock(InputDriver.class);

    @DisplayName("Should diaplay Quit message when performing quit command")
    @Test
    void testQuit() {
        quit.perform(library, outputDriver, inputDriver);
        verify(outputDriver).println("Bye... Come again");
    }
}