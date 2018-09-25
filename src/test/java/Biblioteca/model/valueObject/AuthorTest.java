package Biblioteca.model.valueObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    Author mrinal, arpan;

    @BeforeEach
    void init(){
        mrinal = new Author("Mrinal");
        arpan = new Author("Arpan");
    }
    @DisplayName("get Mrinal when converting author name Mrinal to String")
    @Test
    void testToStringMrinal(){
        assertEquals("Mrinal",mrinal.toString());
    }

    @DisplayName("get Arpan when converting author name Arpan to String")
    @Test
    void testGetNameArpan(){
        assertEquals("Arpan", arpan.toString());
    }

    @DisplayName("get Mrinal when converting author name Mrinal to String")
    @Test
    void testGetNameMrinal(){
        assertEquals("Mrinal", mrinal.getName());
    }

    @DisplayName("get Arpan when converting author name Arpan to String")
    @Test
    void testToStringArpan(){
        assertEquals("Arpan", arpan.getName());
    }

    @DisplayName("Mrinal = Mrinal")
    @Test
    void testEqualsMrinal(){
        assertEquals(new Author("Mrinal"), mrinal);
    }

    @DisplayName("get Arpan when converting author name Arpan to String")
    @Test
    void testEqualsArpan(){
        assertEquals(new Author("Arpan"), arpan);
    }

    @DisplayName("get Arpan when converting author name Arpan to String")
    @Test
    void testNotEquals(){
        assertNotEquals(new Author("Mrinal"), arpan);
    }
}