package org.library.models.dao.interfaces;

import org.library.models.entities.reader.Reader;

import java.util.List;

public interface ReaderDao {
    void insert(Reader object);
    void update(Long id, Reader object);
    void delete(Long id);
    Reader findByID(Long id);
    List<Reader> findAll();
}
