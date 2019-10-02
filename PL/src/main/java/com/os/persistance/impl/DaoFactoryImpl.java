package com.os.persistance.impl;

import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.*;
import com.os.persistance.poolConnection.ConnectionPoolHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactoryImpl extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public BookDao createBookDao() {
        return new BookDaoImpl(getConnection());
    }

    @Override
    public AuthorDao createAuthorDao() {
        return new AuthorDaoImpl(getConnection());
    }

    @Override
    public BookAttributeDao createBookAttributeDao() {
        return new BookAttributeDaoImpl(getConnection());
    }

    @Override
    public ReaderDao createReaderDao() {
        return new ReaderDaoImpl(getConnection());
    }

    @Override
    public OrderDao createOrderDao() {
        return new OrderDaoImpl(getConnection());
    }

    @Override
    public AdministratorDao createAdministratorDao() {
        return new AdministratorDaoImpl(getConnection());
    }

    @Override
    public LanguageDao createLanguageDao() {
        return new LanguageDaoImpl(getConnection());
    }

    private Connection getConnection(){
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}