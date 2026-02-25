package dao.readerDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.library.models.dao.impl.ReaderDaoImpl;
import org.library.models.dao.interfaces.ReaderDao;
import org.library.models.entities.reader.Reader;

public class ReaderDaoTest {
    private static Reader reader;
    private static ReaderDao readerDao;

    @BeforeAll
    public static void setup(){
        reader = new Reader(null, "Jorge Assunção", "44433355599", "jorgeassuncao@gmail.com", "+5599988029558",
                "65602000", "Rua da Manga", "146", "Cohab", "Caxias", "Maranhão");
        readerDao = new ReaderDaoImpl();
    }

    @Test
    public void insertDataReaderInDataBase(){
        readerDao.insert(reader);

        Assertions.assertNotNull(reader.getId());
        System.out.println(reader.getId());
    }

    @Test
    public void updateReaderInDataBase(){
    }


}
