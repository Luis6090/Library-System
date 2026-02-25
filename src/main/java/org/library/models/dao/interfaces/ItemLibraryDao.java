package org.library.models.dao.interfaces;

import org.library.models.entities.itemLibrary.ItemLibrary;

import java.sql.Connection;

public interface ItemLibraryDao {
    Long insert(ItemLibrary object, Connection connection);
    void update(Long id, ItemLibrary object, Connection connection);
    void delete(Long id, Connection connection);
}
