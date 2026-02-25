package org.library.models.dao.impl;

import org.library.database.DataBaseConnection;
import org.library.exception.DaoException;
import org.library.models.dao.interfaces.ItemLibraryDao;
import org.library.models.entities.itemLibrary.ItemLibrary;

import java.sql.*;

public class ItemLibraryDaoImpl implements ItemLibraryDao {
    @Override
    public Long insert(ItemLibrary object, Connection connection) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(
                 "INSERT INTO itemLibrary " +
                     "(titulo, quantity, description, yearOfPublication, status, typeItem)" +
                     " VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, object.getTitle());
            preparedStatement.setInt(2, object.getQuantity());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setDate(4, Date.valueOf(object.getDatePublication()));
            preparedStatement.setObject(5, object.getStatus().name(), Types.OTHER);
            preparedStatement.setObject(6, object.getTypeItem().name(), Types.OTHER);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0){
                System.out.println("Insert sucess!");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    Long id = resultSet.getLong(1);
                    object.setId(id);
                    return id;
                }
                DataBaseConnection.closeResultSet(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Long id, ItemLibrary object, Connection connection) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(
                    "UPDATE itemLibrary " +
                         "SET titulo = COALESCE(?, titulo), quantity = COALESCE(?, quantity), description = COALESCE(?, description), " +
                         "yearOfPublication = COALESCE(?, yearOfPublication), status = COALESCE(?, status), typeItem = COALESCE(?, typeItem) " +
                         "WHERE idItem = ?"
            );

            preparedStatement.setString(1, object.getTitle());
            preparedStatement.setInt(2, object.getQuantity());
            preparedStatement.setString(3, object.getDescription());
            if (object.getDatePublication() == null) preparedStatement.setDate(4, null);
            else preparedStatement.setDate(4, Date.valueOf(object.getDatePublication()));
            if(object.getStatus() == null) preparedStatement.setObject(5, null, Types.OTHER);
            else preparedStatement.setObject(5, object.getStatus().name(), Types.OTHER);
            if(object.getStatus() == null) preparedStatement.setObject(6, null, Types.OTHER);
            else preparedStatement.setObject(6, object.getTypeItem().name(), Types.OTHER);
            preparedStatement.setLong(7, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Update sucess!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Long id, Connection connection) {
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(
                              "DELETE FROM itemLibrary " +
                                  "WHERE idItem = ?"
            );

            preparedStatement.setLong(1, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0) System.out.println("Delete sucess!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataBaseConnection.closeStatement(preparedStatement);
        }
    }

}
