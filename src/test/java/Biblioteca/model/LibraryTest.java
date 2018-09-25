package Biblioteca.model;

import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book1, book2, bookNotInLibrary;

    @BeforeEach
    void init() {
        book1 = new Book(new Title("Book1"), new Author("Mrinal"), new Year(1996));
        book2 = new Book(new Title("Book2"), new Author("Arpan"), new Year(1997));
        bookNotInLibrary = new Book(new Title("Book not in library"),
                new Author("Nikhil"), new Year(1897));
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        library = new Library(books);
    }

    @DisplayName("Should print all the books")
    @Test
    void testDisplayingBookList() {
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());
    }

    @DisplayName("Should remove the book1 on check out")
    @Test
    void testCheckOutBook1() {
        library.checkOut(new Title("Book1"));
        assertEquals(Arrays.asList("Book2", "Arpan", "1997"), library.getBookDetails());
    }

    @DisplayName("Should remove the book2 on check out")
    @Test
    void testCheckOutBook2() {
        library.checkOut(new Title("Book2"));
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996"), library.getBookDetails());
    }

    @DisplayName("Should contain book1 in Library")
    @Test
    void testContainsBook1() {
        assertTrue(library.contains(new Title("Book1")));
    }

    @DisplayName("Should contain book2 in Library")
    @Test
    void testContainsBook2() {
        assertTrue(library.contains(new Title("Book2")));
    }

    @DisplayName("Should not contain book not in library")
    @Test
    void testNotContainsBook() {
        assertFalse(library.contains(new Title("Book not in library")));
    }

    @DisplayName("Should have checked book1 in after its checked")
    @Test
    void testHasCheckedBook1() {
        assertFalse(library.hasCheckedOut(new Title("Book1")));
        library.checkOut(new Title("Book1"));
        assertTrue(library.hasCheckedOut(new Title("Book1")));
    }

    @DisplayName("Should have checked book2 in after its checked")
    @Test
    void testHasCheckedBook2() {
        assertFalse(library.hasCheckedOut(new Title("Book2")));
        library.checkOut(new Title("Book2"));
        assertTrue(library.hasCheckedOut(new Title("Book2")));
    }

    @DisplayName("Should not have checked book not in library")
    @Test
    void testHasNotCheckedBook() {
        assertFalse(library.hasCheckedOut(new Title("Book not in library")));
    }

    @DisplayName("Should be able to return book checked out")
    @Test
    void testReturnBook1() {
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());

        library.checkOut(new Title("Book1"));
        assertEquals(Arrays.asList("Book2", "Arpan", "1997"), library.getBookDetails());

        library.returnBook(new Title("Book1"));
        assertEquals(Arrays.asList("Book2", "Arpan", "1997", "Book1", "Mrinal", "1996"),
                library.getBookDetails());
    }

    @DisplayName("Should be able to return all books checked out")
    @Test
    void testReturnBook2() {
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());

        library.checkOut(new Title("Book1"));
        library.checkOut(new Title("Book2"));
        assertEquals(Arrays.asList(), library.getBookDetails());

        library.returnBook(new Title("Book1"));
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996"),
                library.getBookDetails());

        library.returnBook(new Title("Book2"));
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());
    }

    @DisplayName("Should be unchanged on trying to return book not checked out")
    @Test
    void testNotReturnBookIfNotCheckedOut() {
        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());

        library.returnBook(new Title("Book1"));

        assertEquals(Arrays.asList("Book1", "Mrinal", "1996", "Book2", "Arpan", "1997"),
                library.getBookDetails());
    }
}