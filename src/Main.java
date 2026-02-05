import database.DataBaseConnection;
import models.dao.InterfaceDAO;
import models.dao.impl.reader.ReaderDAOImpl;
import models.entities.reader.Reader;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        InterfaceDAO<Long, Reader> repositoryReader = new ReaderDAOImpl();
        Reader reader1 = new Reader(null, null, null, "gabrielle10@gmail.com", "9987654321", null, null, null,
                                    null, null, null);
        repositoryReader.update(6L, reader1);
    }
}