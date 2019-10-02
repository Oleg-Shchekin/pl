package com.os.service.impl;

import com.os.entity.Author;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.AuthorDao;
import com.os.persistance.poolConnection.TransactionManager;

import java.util.List;

public class AuthorServiceImpl {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(Author author){
        TransactionManager.getInstance().beginTransaction();
        try(AuthorDao authorDao = daoFactory.createAuthorDao()){
            authorDao.create(author);
        }
        if (author != null) {
            TransactionManager.getInstance().commit();
        } else {
            TransactionManager.getInstance().rollback();
        }
    }

    public void update(){

    }

    public List<Author> getAllAuthors(){
        return null;
    }

    public Author getAuthorById(){
        return null;
    }

    public void delete(){

    }
}
