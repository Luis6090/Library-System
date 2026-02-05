package models.dao.impl.reader;

import exception.DataBaseException;
import models.dao.InterfaceDAO;
import database.DataBaseConnection;
import models.entities.reader.Reader;

import java.sql.*;
import java.util.List;

public class ReaderDAOImpl implements InterfaceDAO<Long, Reader> {
    @Override
    public void insert(Reader object) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO reader " +
                    "(namereader, cpf, email, phoneNumber, cep, adressLine, adressNumber, neighborhood, city, statecountry)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getCPF());
            preparedStatement.setString(3, object.getEmail());
            preparedStatement.setString(4, object.getPhoneNumber());
            preparedStatement.setString(5, object.getCEP());
            preparedStatement.setString(6, object.getAdressLine());
            preparedStatement.setString(7, object.getAdressNumber());
            preparedStatement.setString(8, object.getNeighborhood());
            preparedStatement.setString(9, object.getCity());
            preparedStatement.setString(10, object.getStateCountry());

            int lineUpdate = preparedStatement.executeUpdate();
            if(lineUpdate > 0){
                System.out.println("Insert sucess!");
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getLong(1));
                }
                DataBaseConnection.closeResultSet(resultSet);
            }
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, Reader object) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(
                    "UPDATE reader " +
                        "SET namereader = COALESCE(?, namereader), email = COALESCE(?, email), phoneNumber = COALESCE(?, phoneNumber), cep = COALESCE(?, cep), " +
                        "adressLine = COALESCE(?, adressLine), adressNumber = COALESCE(?, adressNumber),neighborhood = COALESCE(?, neighborhood) ,city = COALESCE(?, city), " +
                        " stateCountry = COALESCE(?, stateCountry)" +
                        "WHERE idreader = ?"
            );

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getEmail());
            preparedStatement.setString(3, object.getPhoneNumber());
            preparedStatement.setString(4, object.getCEP());
            preparedStatement.setString(5, object.getAdressLine());
            preparedStatement.setString(6, object.getAdressNumber());
            preparedStatement.setString(7, object.getNeighborhood());
            preparedStatement.setString(8, object.getCity());
            preparedStatement.setString(9, object.getStateCountry());
            preparedStatement.setLong(10, id);

            int lineUpdate = preparedStatement.executeUpdate();
            if (lineUpdate > 0){
                System.out.println("Update Sucess!");
            }
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection = DataBaseConnection.getConnection();
        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM reader " +
                         "WHERE idreader = ?"
            );

            preparedStatement.setLong(1, id);

            int rowUpdate = preparedStatement.executeUpdate();
            if(rowUpdate > 0){
                System.out.println("Delete suscess!");
            }
            DataBaseConnection.closeStatement(preparedStatement);
            DataBaseConnection.closeConnection(connection);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reader findByID(Long aLong) {
        return null;
    }

    @Override
    public List<Reader> findAll() {
        return List.of();
    }

}
