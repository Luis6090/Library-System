package db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library.database.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    @Test
    public void openConnectionDataBase(){
        Connection connection = DataBaseConnection.getConnection();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(connection, "Connections don't exists!!"),
                () -> Assertions.assertFalse(connection.isClosed(), "Connection close")
        );

        DataBaseConnection.closeConnection(connection);
    }

    @Test
    public void closeConnectionDataBase() {
        Connection connection = DataBaseConnection.getConnection();
        DataBaseConnection.closeConnection(connection);

        Assertions.assertAll("DataBase close",
                () -> Assertions.assertTrue(connection.isClosed(), "Connection open!!")
        );
    }
}
