package org.library.models.dao.interfaces;

import org.library.models.entities.book.Book;

import java.util.List;

public interface BookDao {
    void insert(Book object);
    void update(Long id, Book object);
    void delete(Long id);
    Book findByID(Long id);
    List<Book> findAll();
}
