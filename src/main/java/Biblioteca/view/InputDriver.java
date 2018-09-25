package Biblioteca.view;

import java.util.Scanner;

// Driver to manage inputs from console
public class InputDriver {
    private final Scanner scanner;

    public InputDriver() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
