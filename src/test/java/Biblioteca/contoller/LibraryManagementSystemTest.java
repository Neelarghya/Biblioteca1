package Biblioteca.contoller;

import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Author;
import Biblioteca.model.Book;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Biblioteca.common.Constants.NUMBER_OF_COLUMNS_IN_BOOK_DETAILS;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    private LibraryManagementSystem libraryManagementSystem;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Book book1, book2;

    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        when(inputDriver.getIntInput()).thenReturn(1).thenReturn(0);
        book1 = new Book(new Title("Book1"), new Author("Mrinal"), new Year(1996));
        book2 = new Book(new Title("Book2"), new Author("Arpan"), new Year(1997));
        final List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        final Library library = new Library(books);
        libraryManagementSystem = new LibraryManagementSystem(library, outputDriver, inputDriver);
    }

    @DisplayName("LibraryManagementSystem should welcome customer")
    @Test
    void testWelcome() {
        verifyZeroInteractions(outputDriver);
        libraryManagementSystem.start();
        verify(outputDriver).println("Welcome Customer to Biblioteca");
    }

    @DisplayName("Should println all the books")
    @Test
    void testDisplayingBookList() {
        verifyZeroInteractions(outputDriver);
        libraryManagementSystem.start();
        verify(outputDriver).printInColumns(Arrays.asList(
                "Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }

    @DisplayName("Should not println books not in the system")
    @Test
    void testDisplayingBookListNotDisplayThoseNotIn() {
        libraryManagementSystem.start();
        verify(outputDriver, times(0))
                .printInColumns(Arrays.asList("bookNotInLibrary"), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }

    @DisplayName("Should show 'Select a valid option!' when an option more than number of menus is given")
    @Test
    void testInvalidOptionForGreater() {
        verifyZeroInteractions(outputDriver);
        when(inputDriver.getIntInput()).thenReturn(Menu.values().length).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).println("Select a valid option!");
    }

    @DisplayName("Should show 'Select a valid option!' when selecting option less than 0")
    @Test
    void testInvalidOptionForLess() {
        verifyZeroInteractions(outputDriver);
        when(inputDriver.getIntInput()).thenReturn(-1).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).println("Select a valid option!");
    }

    @DisplayName("Should remove book that's checked out")
    @Test
    void testCheckOutBook1() {
        verifyZeroInteractions(outputDriver);
        when(inputDriver.getInput()).thenReturn("Book1");
        when(inputDriver.getIntInput()).thenReturn(2).thenReturn(1).thenReturn(0);
        libraryManagementSystem.start();
        verify(outputDriver).printInColumns(Arrays.asList("Book2", "Arpan", "1997"), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }

    @AfterEach
    void cleanUp() {
        System.setIn(System.in);
    }
}