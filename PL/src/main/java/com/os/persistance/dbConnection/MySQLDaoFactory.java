package com.os.persistance.dbConnection;


import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.*;

public  class MySQLDaoFactory extends DaoFactory {

    public MySQLDaoFactory() {
        super();
    }

    @Override
    public BookDao createBookDao() {
        return null;
    }

    @Override
    public AuthorDao createAuthorDao() {
        return null;
    }

    @Override
    public BookAttributeDao createBookAttributeDao() {
        return null;
    }

    @Override
    public ReaderDao createReaderDao() {
        return null;
    }

    @Override
    public OrderDao createOrderDao() {
        return null;
    }

    @Override
    public AdministratorDao createAdministratorDao() {
        return null;
    }

    @Override
    public LanguageDao createLanguageDao() {
        return null;
    }
}