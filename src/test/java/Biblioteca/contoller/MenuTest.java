package Biblioteca.contoller;

import Biblioteca.model.Book;
import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Biblioteca.common.Constants.NUMBER_OF_COLUMNS_IN_BOOK_DETAILS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Type of action user wants to perform
class MenuTest {
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Book book1, book2, bookNotInLibrary;
    private Library library;
    private List<Book> books;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        library = mock(Library.class);
        book1 = new Book(new Title("Book1"), new Author("Mrinal"), new Year(1996));
        book2 = new Book(new Title("Book2"), new Author("Arpan"), new Year(1997));
        bookNotInLibrary = new Book(new Title("Book not in library"), new Author("Nikhil"), new Year(1897));
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
    }

    @DisplayName("Enter 1 to List Books should be displayed as menu option")
    @Test
    void testGetMenuListBooks() {
        assertEquals("Enter 1 to List Books", Menu.LIST_BOOKS.getMenu());
    }

    @DisplayName("Should list books")
    @Test
    void testPerformListBooks() {
        library = new Library(books);
        Menu.LIST_BOOKS.perform(library, outputDriver, inputDriver);
        verify(outputDriver).printInColumns(Arrays.asList(
                "Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }

    @DisplayName("Enter 0 to Quit should be displayed as menu option")
    @Test
    void testGetMenuQuit() {
        assertEquals("Enter 0 to Quit", Menu.QUIT.getMenu());
    }

    @DisplayName("Should list books")
    @Test
    void testPerformQuit() {
        Menu.QUIT.perform(library, outputDriver, inputDriver);
        verify(outputDriver).println("Bye... Come again");
    }

    @DisplayName("Enter 2 to Check Out a book should be displayed as menu option")
    @Test
    void testGetMenuCheckOut() {
        assertEquals("Enter 2 to Check Out a book", Menu.CHECK_OUT.getMenu());
    }

    @DisplayName("Should checkOut Book1 on check out if library has the book and show message")
    @Test
    void testPerformCheckOutSuccessful() {
        when(inputDriver.getInput()).thenReturn("Book1");
        when(library.contains(new Title("Book1"))).thenReturn(true);

        Menu.CHECK_OUT.perform(library, outputDriver, inputDriver);

        verify(library).checkOut(new Title("Book1"));
        verify(outputDriver).println("Thank you! Enjoy the book");
    }

    @DisplayName("Should not checkOut Book not in library, on check out and show unsuccessful message")
    @Test
    void testNotRemoveCheckOutUnsuccessful() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.contains(new Title("Book not in Library"))).thenReturn(false);

        Menu.CHECK_OUT.perform(library, outputDriver, inputDriver);

        verify(library, times(0)).checkOut(new Title("Book not in Library"));
        verify(outputDriver).println("That book is not available.");
    }

    @DisplayName("Enter 2 to Check Out a book should be displayed as menu option")
    @Test
    void testGetMenuReturn() {
        assertEquals("Enter 3 to Return a book", Menu.RETURN.getMenu());
    }

    @DisplayName("Should return Book1 on and show message")
    @Test
    void testPerformReturnSuccessful() {
        when(inputDriver.getInput()).thenReturn("Book1");

        when(library.hasCheckedOut(new Title("Book1"))).thenReturn(true);
        Menu.RETURN.perform(library, outputDriver, inputDriver);

        verify(library).returnBook(new Title("Book1"));
        verify(outputDriver).println("Thank you for returning the book.");
    }

    @DisplayName("Should not be able to return Book not in checked out, show unsuccessful message")
    @Test
    void testNotAddReturnUnsuccessful() {
        when(inputDriver.getInput()).thenReturn("Book not in Library");
        when(library.hasCheckedOut(new Title("Book not in Library"))).thenReturn(false);

        Menu.RETURN.perform(library, outputDriver, inputDriver);

        verify(outputDriver).print("Enter name of the book you want to return: ");
        verify(library, times(0)).returnBook(new Title("Book not in Library"));
        verify(outputDriver).println("That is not a valid book to return.");
    }

    @DisplayName("Should display 'Select a valid option!' for INVALID OPTION")
    @Test
    void testPerformInvalidOption(){
        Menu.INVALID_OPTION.perform(library, outputDriver, inputDriver);
        verify(outputDriver).println("Select a valid option!");
    }
}