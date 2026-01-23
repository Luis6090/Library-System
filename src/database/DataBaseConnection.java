package database;

import database.exception.DataBaseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {
    private static Connection connection = null;

    private static Properties loadFile(){
        //Utilizem o arquivo template.properties para o acesso do banco de dados
        try(FileInputStream file = new FileInputStream("config.properties")){
            Properties fileProperties = new Properties();
            fileProperties.load(file);
            return fileProperties;
        }
        catch (IOException fileError) {
            throw new DataBaseException(fileError.getMessage());
        }
    }

    public static Connection getConnection(){
        if(connection == null) {
            try {
                Properties fileProperties = loadFile();
                String url = fileProperties.getProperty("url");
                connection = DriverManager.getConnection(url, fileProperties);
            } catch (SQLException SQLError) {
                throw new DataBaseException(SQLError.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        } catch (SQLException SQLError) {
            throw new DataBaseException(SQLError.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
        try{
            statement.close();
        } catch (SQLException SQLError) {
            throw new DataBaseException(SQLError.getMessage());
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        try{
            resultSet.close();
        } catch (SQLException SQLError) {
            throw new DataBaseException(SQLError.getMessage());
        }
    }
}
