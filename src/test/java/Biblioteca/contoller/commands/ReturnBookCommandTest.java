package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Title;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ReturnBookCommandTest {
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private Command command;

    @BeforeEach
    void init() {
        command = new ReturnBookCommand();
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = mock(Library.class);
    }

    @DisplayName("Should bea able to return Book1 after check out")
    @Test
    void testPerformReturn() {
        when(inputDriver.getInput()).thenReturn("Book1");

        when(library.hasCheckedOut(new Title("Book1"))).thenReturn(true);
        command.perform(library, outputDriver, inputDriver);

        verify(outputDriver).print("Enter name of the book you want to return: ");
        verify(library).returnBook(new Title("Book1"));
    }

    @DisplayName("Should return Book1 on and show message")
    @Test
    void testPerformReturnSuccessful() {
        when(inputDriver.getInput()).thenReturn("Book1");

        when(library.hasCheckedOut(new Title("Book1"))).thenReturn(true);
        command.perform(library, outputDriver, inputDriver);

        verify(library).returnBook(new Title("Book1"));
        verify(outputDriver).println("Thank you for returning the book.");
    }

    @DisplayName("Should not return Book not checked out and not show unsuccessful message")
    @Test
    void testNotAddReturn() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.hasCheckedOut(new Title("Book not in library"))).thenReturn(false);

        command.perform(library, outputDriver, inputDriver);

        verify(library, times(0)).returnBook(new Title("Book not in Library"));
        verify(outputDriver).println("That is not a valid book to return.");
    }

    @DisplayName("Should not be able to return Book not in checked out, show unsuccessful message")
    @Test
    void testNotAddReturnUnsuccessful() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.hasCheckedOut(new Title("Book not in Library"))).thenReturn(false);

        command.perform(library, outputDriver, inputDriver);

        verify(outputDriver).print("Enter name of the book you want to return: ");
        verify(library, times(0)).returnBook(new Title("Book not in Library"));
        verify(outputDriver).println("That is not a valid book to return.");
    }
}