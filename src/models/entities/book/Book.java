package models.entities.book;

import models.entities.book.utils.Gender;
import models.entities.itemLibrary.ItemLibrary;
import models.entities.itemLibrary.utils.Status;
import models.entities.itemLibrary.utils.TypeItem;

import java.time.LocalDate;
import java.util.List;

public class Book extends ItemLibrary {
    private String isbn;
    private Integer edition;
    private Gender gender;
    private List<Author> authors;
    private List<Publisher> publishers;


    public Book(Long id,
                String title,
                Integer quantity,
                String description,
                LocalDate datePublication,
                Status status,
                TypeItem typeItem,
                String isbn,
                Integer edition,
                Gender gender,
                List<Author> authors,
                List<Publisher> publishers)
    {
        super(id, title, quantity, description, datePublication, status, typeItem);
        this.isbn = isbn;
        this.edition = edition;
        this.gender = gender;
        this.authors = authors;
        this.publishers = publishers;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                "isbn='" + isbn + '\'' +
                ", edition=" + edition +
                ", gender=" + gender +
                ", authors=" + authors +
                ", publishers=" + publishers +
                '}';
    }
}
