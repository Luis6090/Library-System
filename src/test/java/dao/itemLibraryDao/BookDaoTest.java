package dao.itemLibraryDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.library.models.dao.impl.BookDaoImpl;
import org.library.models.dao.interfaces.BookDao;
import org.library.models.entities.book.Author;
import org.library.models.entities.book.Book;
import org.library.models.entities.book.Publisher;
import org.library.models.entities.book.utils.Gender;
import org.library.models.entities.itemLibrary.utils.Status;
import org.library.models.entities.itemLibrary.utils.TypeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDaoTest {
    private static Book book;
    private static BookDao bookDao;

    @BeforeAll
    public static void setup(){
        List<Author> authors = new ArrayList<>(Arrays.asList(new Author(null, "Lima Sousa"), new Author(null, "Jorge Lima")));
        List<Publisher> publishers = new ArrayList<>(Arrays.asList(new Publisher(null, "LeonHart")));
        book = new Book(null, "Favela e Senzala", 20, "", LocalDate.of(1973, 6, 22),
                Status.AVAILABLE, TypeItem.BOOK, "9785617985491", 2, Gender.ROMANCE, authors, publishers);

        bookDao = new BookDaoImpl();
    }

    @Test
    public void insertBookInDataBase(){
        bookDao.insert(book);

        Assertions.assertNotNull(book.getId());
        System.out.println(book.getId());
    }

    @Test
    public void updateBookInDataBase(){
        Book updateBook = new Book(null, "Crepusculo", 8, "Livro sobre vampiros", null, null,
                                    null, "1234997029091", 3, Gender.ROMANCE, null, null);
        bookDao.update(2L, updateBook);
    }

    @Test
    public void deleteBookInDataBase(){
        bookDao.delete(4L);
    }
}
