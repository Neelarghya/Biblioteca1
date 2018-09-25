package Biblioteca.view;

import java.util.List;

// Driver to manage printing output to console
public class OutputDriver {
    public void println(String output) {
        System.out.println(output);
    }

    public void print(String output) {
        System.out.print(output);
    }

    public void printInColumns(List<String> outputs, int numberOfColumns) {
        for (int index = 0; index < outputs.size(); index += numberOfColumns) {
            for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
                System.out.format("%-30s", outputs.get(index + columnNumber));
            }
            System.out.println();
        }
    }

    public void printDivider(){
        println("==================================================================\n");
    }
}
