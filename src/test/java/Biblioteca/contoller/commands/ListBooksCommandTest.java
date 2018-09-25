package Biblioteca.contoller.commands;

import Biblioteca.model.Library;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static Biblioteca.common.Constants.NUMBER_OF_COLUMNS_IN_BOOK_DETAILS;
import static org.mockito.Mockito.*;

class ListBooksCommandTest {
    private Command listBooks = new ListBooksCommand();
    private Library library = mock(Library.class);
    private OutputDriver outputDriver = mock(OutputDriver.class);
    private InputDriver inputDriver = mock(InputDriver.class);

    @DisplayName("Should List what library returns as book details")
    @Test
    void testListBookDetails() {
        when(library.getBookDetails()).thenReturn(Arrays.asList("Book Details"));
        listBooks.perform(library, outputDriver, inputDriver);

        verify(library).getBookDetails();
        verify(outputDriver).printInColumns(library.getBookDetails(), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }

    @DisplayName("Should List the Book details")
    @Test
    void testListBooks() {
        when(library.getBookDetails()).thenReturn(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"));
        listBooks.perform(library, outputDriver, inputDriver);

        verify(library).getBookDetails();
        verify(outputDriver).printInColumns(library.getBookDetails(), NUMBER_OF_COLUMNS_IN_BOOK_DETAILS);
    }
}