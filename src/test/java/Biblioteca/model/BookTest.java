package Biblioteca.model;

import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {
    private Book book1, book2;

    @BeforeEach
    void init() {
        book1 = new Book(new Title("Book1"), new Author("Mrinal"), new Year(1996));
        book2 = new Book(new Title("Book2"), new Author("Arpan"), new Year(1995));
    }

    @DisplayName("Should return Book1\tMrinal\t1996")
    @Test
    void testToString1() {
        assertEquals("Book1\tMrinal\t1996",
                book1.toString());
    }

    @DisplayName("Should return Book2\tArpan\t1995")
    @Test
    void testToString2() {
        assertEquals("Book2\tArpan\t1995",
                book2.toString());
    }

    @DisplayName("Should return Book1")
    @Test
    void testGetTitle() {
        assertEquals(new Title("Book1"),
                book1.getTitle());
    }

    @DisplayName("Should return Book2")
    @Test
    void testGetBook2() {
        assertEquals(new Title("Book2"),
                book2.getTitle());
    }

    @DisplayName("Should not return Book1")
    @Test
    void testNotGetTitle() {
        assertNotEquals(new Title("Book1"),
                book2.getTitle());
    }

    @DisplayName("Should return Mrinal")
    @Test
    void testGetAuthor1() {
        assertEquals(new Author("Mrinal"),
                book1.getAuthor());
    }

    @DisplayName("Should return Arpan")
    @Test
    void testGetAuthor2() {
        assertEquals(new Author("Arpan"),
                book2.getAuthor());
    }

    @DisplayName("Should not return Mrinal")
    @Test
    void testNotGetAuthor() {
        assertNotEquals(new Title("Mrinal"),
                book2.getAuthor());
    }

    @DisplayName("Should return 1996")
    @Test
    void testGetYear1() {
        assertEquals(new Year(1996),
                book1.getYear());
    }

    @DisplayName("Should return 1995")
    @Test
    void testGetYear2() {
        assertEquals(new Year(1995),
                book2.getYear());
    }

    @DisplayName("Should not return 1996")
    @Test
    void testNotGetYear() {
        assertNotEquals(new Year(1996),
                book2.getYear());
    }

    @DisplayName("Book1 = Book1")
    @Test
    void testEquals() {
        assertEquals(new Book(new Title("Book1"), new Author("M"), new Year(1896)),
                book1);
    }

    @DisplayName("Book1 not = Book2")
    @Test
    void testNotEquals() {
        assertNotEquals(new Book(new Title("Book1"), new Author("M"), new Year(1896)),
                book2);
    }
}