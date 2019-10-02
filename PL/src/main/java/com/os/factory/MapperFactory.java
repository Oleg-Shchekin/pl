package com.os.factory;

import com.os.entity.*;
import com.os.persistance.mapFunction.*;

public class MapperFactory {

    private static  MapperFactory instance;

    private Mapper<Administrator> administratorMapper;
    private Mapper<Author> authorMapper;
    private Mapper<Book> bookMapper;
    private Mapper<BookAttribute> bookAttributeMapper;
    private Mapper<Language> languageMapper;
    private Mapper<Order> orderMapper;
    private Mapper<Reader> readerMapper;

    private MapperFactory() {
        administratorMapper = new AdministratorMapper();
        authorMapper = new AuthorMapper();
        bookAttributeMapper = new BookAttributeMapper();
        bookMapper = new BookMapper();
        languageMapper = new LanguageMapper();
        orderMapper = new OrderMapper();
        readerMapper = new ReaderMapper();
    }
    /**
     * Get instance of Mapper Factory
     * @return instance of factory
     */

    public static MapperFactory getInstance(){
        if(instance == null){
            synchronized (MapperFactory.class){
                if(instance == null){
                    instance = new MapperFactory();
                }
            }
        }
        return instance;
    }
    /**
     * Get Mapper<Administrator> object
     * @return Administrator Mapper
     */
    public Mapper<Administrator> getAdministratorMapper() {
        return administratorMapper;
    }

    /**
     * Get Mapper<Author> object
     * @return Author Mapper
     */
    public Mapper<Author> getAuthorMapper() {
        return authorMapper;
    }

    /**
     * Get Mapper<BookAttribute> object
     * @return BookAttribute Mapper
     */
    public Mapper<BookAttribute> getBookAttributeMapper() {
        return bookAttributeMapper;
    }

    /**
     * Get Mapper<Book> object
     * @return Book Mapper
     */
    public Mapper<Book> getBookMapper() {
        return bookMapper;
    }

    /**
     * Get Mapper<Language> object
     * @return Language Mapper
     */
    public Mapper<Language> getLanguageMapper() {
        return languageMapper;
    }

    /**
     * Get Mapper<Order> object
     * @return Order Mapper
     */
    public Mapper<Order> getOrderMapper() {
        return orderMapper;
    }

    /**
     * Get Mapper<Reader> object
     * @return Reader Mapper
     */
    public Mapper<Reader> getReaderMapper() {
        return readerMapper;
    }
}
