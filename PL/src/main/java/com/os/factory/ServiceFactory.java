//package com.os.factory;
//
//
//import com.os.service.impl.*;
//import com.os.service.interfaces.*;
//
//public class ServiceFactory {
//
//    private static ServiceFactory instance ;
//
//    private AdministratorService administratorService;
//    private AuthorService authorService;
//    private BookAttributeService bookAttributeService;
//    private BookService bookService;
//    private LanguageService languageService;
//    private OrderService orderService;
//    private ReaderService readerService;
//
//    public ServiceFactory() {
//        administratorService = new AdministratorServiceImpl();
//        authorService = new AuthorServiceImpl();
//        bookAttributeService = new BookAttributeServiceImpl();
//        bookService = new BookServiceImpl();
//        languageService = new LanguageServiceImpl();
//        orderService = new OrderServiceImpl();
//        readerService = new ReaderServiceImpl();
//    }
//
//    public static ServiceFactory getInstance(){
//        if(instance == null){
//            synchronized (ServiceFactory.class){
//                if(instance == null){
//                    instance = new ServiceFactory();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public AdministratorService getAdministratorService() {
//        return administratorService;
//    }
//
//    public AuthorService getAuthorService() {
//        return authorService;
//    }
//
//    public BookAttributeService getBookAttributeService() {
//        return bookAttributeService;
//    }
//
//    public BookService getBookService() {
//        return bookService;
//    }
//
//    public LanguageService getLanguageService() {
//        return languageService;
//    }
//
//    public OrderService getOrderService() {
//        return orderService;
//    }
//
//    public ReaderService getReaderService() { return readerService; }
//}
