package Biblioteca.model;

import Biblioteca.model.valueObject.Author;
import Biblioteca.model.valueObject.Title;
import Biblioteca.model.valueObject.Year;

import java.util.Objects;

// A Document made up of pages
public class Book {
    private final Title title;
    private final Author author;
    private final Year year;

    public Book(Title title, Author author, Year year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title.getValue() + "\t" + author.getName() + "\t" + year.getValue();
    }

    Title getTitle() {
        return title;
    }

    Author getAuthor() {
        return author;
    }

    Year getYear() {
        return year;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Book book = (Book) object;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
