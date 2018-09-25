package Biblioteca.model.valueObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class YearTest {
    Year year1996, year1995;

    @BeforeEach
    void init() {
        year1996 = new Year(1996);
        year1995 = new Year(1995);
    }

    @DisplayName("1996 to string 1996")
    @Test
    void testToString1996() {
        assertEquals("1996", year1996.toString());
    }

    @DisplayName("1995 to string 1995")
    @Test
    void testToString1995() {
        assertEquals("1995", year1995.toString());
    }


    @DisplayName("1996 gets 1996")
    @Test
    void testGetValue1996() {
        assertEquals(1996, year1996.getValue());
    }

    @DisplayName("1995 gets 1995")
    @Test
    void testGetValue1995() {
        assertEquals(1995, year1995.getValue());
    }


    @DisplayName("1996 = 1996")
    @Test
    void testEquals1996() {
        assertEquals(new Year(1996), year1996);
    }

    @DisplayName("1995 = 1995")
    @Test
    void testEquals1995() {
        assertEquals(new Year(1995), year1995);
    }

    @DisplayName("1996 not = 1995")
    @Test
    void testNotEquals() {
        assertNotEquals(new Year(1996), year1995);
    }
}