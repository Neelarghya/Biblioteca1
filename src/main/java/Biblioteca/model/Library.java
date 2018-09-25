package Biblioteca.model;

import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;

import java.util.ArrayList;
import java.util.List;

// A place where books are kept
public class Library {
    private final List<Book> books;
    private final List<Book> checkedOutBooks;

    public Library(List<Book> books) {
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    public List<String> getBookDetails() {
        List<String> outputs = new ArrayList<>();
        addBookDetails(outputs);
        return outputs;
    }

    private void addBookDetails(List<String> outputs) {
        for (Book book : books) {
            outputs.add(book.getTitle().toString());
            outputs.add(book.getAuthor().toString());
            outputs.add(book.getYear().toString());
        }
    }

    public void checkOut(Title title) {
        if (!contains(title)){
            return;
        }

        final Book book = books.get(getBookIndex(books, title));
        books.remove(book);
        checkedOutBooks.add(book);
    }

    private int getBookIndex(List<Book> books, Title title) {
        for (int index = 0; index < books.size(); index++){
            if (books.get(index).getTitle().equals(title)){
                return index;
            }
        }
        return -1;
    }

    public boolean contains(Title title) {
        return books.contains(new Book(title, new Author(""), new Year(0)));
    }

    public boolean hasCheckedOut(Title title){
        return checkedOutBooks.contains(new Book(title, new Author(""), new Year(0)));
    }

    public void returnBook(Title title) {
        if (!hasCheckedOut(title)){
            return;
        }

        final Book book = checkedOutBooks.get(getBookIndex(checkedOutBooks, title));
        checkedOutBooks.remove(book);
        books.add(book);
    }
}
