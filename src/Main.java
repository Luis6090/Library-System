import models.dao.InterfaceDAO;
import models.dao.impl.reader.ReaderDAOImpl;
import models.entities.reader.Reader;

public class Main {
    public static void main(String[] args) {
        InterfaceDAO<Long, Reader> repositoryReader = new ReaderDAOImpl();
        Reader reader1 = new Reader(null, null, null, "gabrielle10@gmail.com", "9988023344", null, null, null,
                                    null, null, null);
        repositoryReader.update(5L, reader1);
        repositoryReader.delete(6L);
    }
}