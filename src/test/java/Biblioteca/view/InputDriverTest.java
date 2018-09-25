package Biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {
    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @DisplayName("Should get input A when input stream has A")
    @Test
    void testInputA() {
        setSystemIn("A\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals("A", inputDriver.getInput());
    }

    @DisplayName("Should get input B when input stream has B")
    @Test
    void testInputB() {
        setSystemIn("B\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals("B", inputDriver.getInput());
    }


    @DisplayName("Should get input 3 when input stream has 3")
    @Test
    void testIntInput() {
        setSystemIn("3\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(3, inputDriver.getIntInput());
    }

    @DisplayName("Should get input 5 when input stream has 5")
    @Test
    void testIntInput5() {
        setSystemIn("5\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(5, inputDriver.getIntInput());
    }

    @AfterEach
    void cleanUp() {
        System.setIn(System.in);
    }
}