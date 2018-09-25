package Biblioteca.model.valueObject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TitleTest {
    @DisplayName("Should return Title1")
    @Test
    void testToString1() {
        assertEquals("Title1", new Title("Title1").toString());
    }

    @DisplayName("Should return Title2")
    @Test
    void testToString2() {
        assertEquals("Title2", new Title("Title2").toString());
    }

    @DisplayName("Should return Title1")
    @Test
    void testToGetTitle1() {
        assertEquals("Title1", new Title("Title1").getValue());
    }

    @DisplayName("Should return Title2")
    @Test
    void testToGetTitle2() {
        assertEquals("Title2", new Title("Title2").getValue());
    }

    @DisplayName("Title2 = Title2")
    @Test
    void testEquals() {
        assertEquals(new Title("Title2"), new Title("Title2"));
    }

    @DisplayName("Title1 not = Title2")
    @Test
    void testNotEquals() {
        assertNotEquals(new Title("Title1"), new Title("Title2"));
    }
}