package com.os.service.impl;

import com.os.entity.Book;
import com.os.entity.BookAttribute;
import com.os.entity.Language;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.BookAttributeDao;
import com.os.persistance.poolConnection.TransactionManager;

public class BookAttributeServiceImpl {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(BookAttribute bookAttribute){
        TransactionManager.getInstance().beginTransaction();
        try(BookAttributeDao bookAttributeDao = daoFactory.createBookAttributeDao()){
            bookAttributeDao.create(bookAttribute);
        }
        if (bookAttribute != null) {
            TransactionManager.getInstance().commit();
        } else {
            TransactionManager.getInstance().rollback();
        }
    }

    public void createMany(String bookAttributesString, Language language, Book book){
        String[] bookAttributeArray = bookAttributesString.split(",");

        for(String attribute : bookAttributeArray){
            BookAttribute bookAttribute = new BookAttribute.BookAttributeBuilder()
                    .setKeyWord(attribute)
                    .setLanguage(language)
                    .setBook(book)
                    .build();
            create(bookAttribute);
        }
    }
}
