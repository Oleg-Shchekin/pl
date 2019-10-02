import com.os.factory.DaoFactory;
import com.os.persistance.impl.DaoFactoryImpl;
import com.os.persistance.interfaces.AuthorDao;
import org.junit.Test;

public class AuthorTest {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private AuthorDao authorDao = daoFactory.createAuthorDao();

    @Test
    public void getAll(){authorDao.getAll();}
}
