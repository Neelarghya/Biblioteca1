package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Title;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckOutBookCommandTest {
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private Command command;

    @BeforeEach
    void init() {
        command = new CheckOutBookCommand();
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = mock(Library.class);
    }

    @DisplayName("Should checkOut Book1 on check out")
    @Test
    void testActCheckOut() {
        when(inputDriver.getInput()).thenReturn("Book1");
        when(library.contains(new Title("Book1"))).thenReturn(true);

        command.perform(library, outputDriver, inputDriver);

        verify(outputDriver).print("Enter name of the book you want to check out: ");
        verify(library).checkOut(new Title("Book1"));
    }

    @DisplayName("Should checkOut Book1 on check out if library has the book and show message")
    @Test
    void testActCheckOutSuccessful() {
        when(inputDriver.getInput()).thenReturn("Book1");
        when(library.contains(new Title("Book1"))).thenReturn(true);

        command.perform(library, outputDriver, inputDriver);

        verify(library).checkOut(new Title("Book1"));
        verify(outputDriver).println("Thank you! Enjoy the book");
    }

    @DisplayName("Should not checkOut Book not in library, on check out and not show successful message")
    @Test
    void testNotRemoveCheckOut() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.contains(new Title("Book not in library"))).thenReturn(false);

        command.perform(library, outputDriver, inputDriver);

        verify(library, times(0)).checkOut(new Title("Book not in Library"));
        verify(outputDriver, times(0)).println("Thank you! Enjoy the book");
    }

    @DisplayName("Should not checkOut Book not in library, on check out and show unsuccessful message")
    @Test
    void testNotRemoveCheckOutUnsuccessful() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.contains(new Title("Book not in Library"))).thenReturn(false);

        command.perform(library, outputDriver, inputDriver);

        verify(library, times(0)).checkOut(new Title("Book not in Library"));
        verify(outputDriver).println("That book is not available.");
    }
}