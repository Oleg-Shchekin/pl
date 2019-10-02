package com.os.service.impl;

import com.os.entity.Reader;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.ReaderDao;
import com.os.persistance.poolConnection.TransactionManager;

import java.util.List;

public class ReaderServiceImpl {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Reader> getAllReaders() {
        List<Reader> readers;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            readers = readerDao.getAll();
        }
        return readers;
    }


    public Reader getReaderById(int id) {
        Reader reader;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            reader = readerDao.getById(id);
        }
        return reader;
    }

    public void create(Reader reader) {
        TransactionManager.getInstance().beginTransaction();
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            readerDao.create(reader);
        }
        if (reader != null) {
            TransactionManager.getInstance().commit();
        } else {
            TransactionManager.getInstance().rollback();
        }
    }

    public boolean isReaderExist(Reader reader) {
        boolean exist;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            exist = readerDao.isExist(reader);
        }
        return exist;
    }

    public Reader getReaderByEmailAndPassword(String email, String password) {
        Reader reader;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            reader = readerDao.getReaderByEmailAndPassword(email, password);
        }
        return reader;
    }

    public boolean isEmailExist(String email) {
        boolean exist;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            exist = readerDao.isEmailExist(email);
        }
        return exist;
    }
}
