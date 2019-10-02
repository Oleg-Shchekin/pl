package com.os.factory;

import com.os.persistance.dbConnection.MySQLDaoFactory;
import com.os.enums.DataBaseSelector;
import com.os.exception.DataBaseConnectionException;
import com.os.exception.DataBaseNotSupportedException;
import com.os.exception.IncorrectPropertyException;
import com.os.persistance.impl.*;
import com.os.persistance.interfaces.*;
import org.apache.log4j.Logger;

public abstract class DaoFactory {
    private static final Logger LOGGER = Logger.getLogger(DaoFactory.class);

    private static DaoFactory daoFactory;

    public abstract BookDao createBookDao();

    public abstract AuthorDao createAuthorDao();

    public abstract BookAttributeDao createBookAttributeDao();

    public abstract ReaderDao createReaderDao();

    public abstract OrderDao createOrderDao();

    public abstract AdministratorDao createAdministratorDao();

    public abstract LanguageDao createLanguageDao();

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    daoFactory = new DaoFactoryImpl();
                }
            }
        }
        return daoFactory;
    }
    public static DaoFactory getDaoFactory(DataBaseSelector dataBase) throws
            DataBaseNotSupportedException,
            IncorrectPropertyException,
            DataBaseConnectionException {
        switch (dataBase) {
            case MY_SQL:
                return new MySQLDaoFactory();
            case MS_SQL:
                LOGGER.error("Database " + dataBase + " not supported yet");
                throw new DataBaseNotSupportedException(dataBase);
            case ORACLE:
                LOGGER.error("Database " + dataBase + " not supported yet");
                throw new DataBaseNotSupportedException(dataBase);
            case POSTGRESS:
                LOGGER.error("Database " + dataBase + " not supported yet");
                throw new DataBaseNotSupportedException(dataBase);
            default:
                LOGGER.error("Database type not set");
                throw new DataBaseNotSupportedException("Database type not set");
        }
    }

    private static DaoFactory instance = null;

    private AdministratorDao administratorDao;
    private AuthorDao authorDao;
    private BookDao bookDao;
    private BookAttributeDao bookAttributeDao;
    private LanguageDao languageDao;
    private OrderDao orderDao;
    private ReaderDao readerDao;


    public AdministratorDao getAdministratorDao() {
        return administratorDao;
    }

    public BookAttributeDao getBookAttributeDao() {
        return bookAttributeDao;
    }

    public AuthorDao getAuthorDao() {return authorDao; }

    public BookDao getBookDao() {
        return bookDao;
    }

    public LanguageDao getLanguageDao() {
        return languageDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public ReaderDao getReaderDao() {
        return readerDao;
    }
}
