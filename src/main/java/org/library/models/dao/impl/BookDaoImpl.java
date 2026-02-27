package org.library.models.dao.impl;

import org.library.database.DataBaseConnection;
import org.library.exception.DaoException;
import org.library.models.dao.interfaces.BookDao;
import org.library.models.dao.interfaces.ItemLibraryDao;
import org.library.models.entities.book.Book;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private ItemLibraryDao itemLibraryDao = new ItemLibraryDaoImpl();

    @Override
    public void insert(Book object) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            connection.setAutoCommit(false);
            Long idBook = itemLibraryDao.insert(object, connection);
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO book " +
                        "(idItemId, ISBN, editionBook, genderBook) " +
                        " VALUES (?, ?, ?, ?)"
            );

            preparedStatement.setLong(1, idBook);
            preparedStatement.setString(2, object.getIsbn());
            preparedStatement.setInt(3, object.getEdition());
            preparedStatement.setObject(4, object.getGender().name(), Types.OTHER);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Insert book success!!");

            insertAuthor(idBook, connection, object);
            insertPublisher(idBook, connection, object);

            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new DaoException(ex.getMessage());
            }
            throw new DaoException(e.getMessage());
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        }
    }

    private void insertPublisher(Long idBook, Connection connection, Book object) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO publisher " +
                     "(idBookId, namePublisher) " +
                     "VALUES (?, ?)"
        );

        for (int row = 0; row < object.getPublishers().size(); row++){
            preparedStatement.setLong(1, idBook);
            preparedStatement.setString(2, object.getPublishers().get(row).getName());
            preparedStatement.addBatch();
        }

        int[] linesUpdates = preparedStatement.executeBatch();
        if(Arrays.stream(linesUpdates).allMatch(x -> x > 0)) System.out.println("Insert publishers success!!");
    }

    private void insertAuthor(Long idBook, Connection connection, Book object) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO author " +
                    "(idBookId, nameAuthor) " +
                    "VALUES (?, ?)"
        );

        for (int row = 0; row < object.getAuthors().size(); row++){
            preparedStatement.setLong(1, idBook);
            preparedStatement.setString(2, object.getAuthors().get(row).getName());
            preparedStatement.addBatch();
        }

        int[] linesUpdates = preparedStatement.executeBatch();
        if(Arrays.stream(linesUpdates).allMatch(x -> x > 0)) System.out.println("Insert authors success!!");

        DataBaseConnection.closeStatement(preparedStatement);
    }

    @Override
    public void update(Long id, Book object) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            connection.setAutoCommit(false);
            itemLibraryDao.update(id, object, connection);
            preparedStatement = connection.prepareStatement(
                    "UPDATE book " +
                        "SET ISBN = COALESCE(?, ISBN), editionBook = COALESCE(?, editionBook), genderBook = COALESCE(?, genderBook) " +
                        "WHERE idItemId  = ?"
            );

            preparedStatement.setString(1, object.getIsbn());
            preparedStatement.setInt(2, object.getEdition());
            if(object.getGender() == null)  preparedStatement.setObject(3, null, Types.OTHER);
            else preparedStatement.setObject(3, object.getGender().name(), Types.OTHER);
            preparedStatement.setLong(4, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Update book success!!");
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            connection.setAutoCommit(false);
            deleteAuthors(id, connection);
            deletePublishers(id, connection);
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM book " +
                        "WHERE idItemId = ?"
            );

            preparedStatement.setLong(1, id);
            
            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Delete one book success!!");

            itemLibraryDao.delete(id, connection);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        }
    }

    private void deletePublishers(Long id, Connection connection) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM publisher " +
                        "WHERE idBookId = ?"
            );

            preparedStatement.setLong(1, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Delete one author success!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
        }

    }

    private void deleteAuthors(Long id, Connection connection) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM author " +
                        "WHERE idBookId = ?"
            );

            preparedStatement.setLong(1, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Delete one author success!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
        }
    }

    @Override
    public Book findByID(Long id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}
