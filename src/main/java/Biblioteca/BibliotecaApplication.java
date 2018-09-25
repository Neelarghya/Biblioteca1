package Biblioteca;

import Biblioteca.contoller.LibraryManagementSystem;
import Biblioteca.model.Book;
import Biblioteca.model.Library;
import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;
import Biblioteca.view.InputDriver;
import Biblioteca.view.OutputDriver;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(new Title("Book1"), new Author("Mrinal Kanti Ghosh"), new Year(1996)));
        books.add(new Book(new Title("Book2"), new Author("Arpan"), new Year(1997)));
        books.add(new Book(new Title("Book3"), new Author("Sayan"), new Year(1995)));
        books.add(new Book(new Title("Book4"), new Author("Bari"), new Year(1994)));

        Library library = new Library(books);
        OutputDriver outputDriver = new OutputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(library, outputDriver, new InputDriver());

        libraryManagementSystem.start();
    }
}
