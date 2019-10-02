package com.os.factory;

import com.os.command.*;
import com.os.command.admin.*;
import com.os.service.impl.*;
import com.os.util.UrlPath;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory instance = null;
    private Map<String, Command> commands = new HashMap<>();

    private BookServiceImpl bookServiceImpl = new BookServiceImpl();
    private ReaderServiceImpl readerServiceImpl = new ReaderServiceImpl();
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
    private AdministratorServiceImpl administratorServiceImpl = new AdministratorServiceImpl();
    private LanguageServiceImpl languageServiceImpl = new LanguageServiceImpl();
    private AuthorServiceImpl authorServiceImpl = new AuthorServiceImpl();
    private BookAttributeServiceImpl bookAttributeServiceImpl = new BookAttributeServiceImpl();

    public CommandFactory() {
        commands.put("/", new HomeCommand(bookServiceImpl, languageServiceImpl));
        commands.put(UrlPath.HOME, new HomeCommand(bookServiceImpl, languageServiceImpl));
        commands.put(UrlPath.CATALOGUE, new CatalogueCommand(bookServiceImpl, languageServiceImpl));
        commands.put(UrlPath.SEARCH, new SearchCommand(bookServiceImpl));
        commands.put(UrlPath.SIGN_IN_PAGE, new SignInPageCommand());
        commands.put(UrlPath.SIGN_UP_PAGE, new SignUpPageCommand());
        commands.put(UrlPath.SIGN_IN, new SignInCommand(readerServiceImpl));
        commands.put(UrlPath.SIGN_UP, new SignUpCommand(readerServiceImpl));
        commands.put(UrlPath.READER_PROFILE, new ReaderProfileCommand(orderServiceImpl));
        commands.put(UrlPath.LOG_OUT, new LogOutCommand());
        commands.put(UrlPath.ADMIN, new AdminCommand(administratorServiceImpl));
        commands.put(UrlPath.ADMIN_SHOW_ALL_BOOKS, new AdminShowAllBooksCommand(bookServiceImpl, orderServiceImpl));
        commands.put(UrlPath.ERROR_403, new Error403Command());
        commands.put(UrlPath.BOOK_ITEM, new BookItemCommand(bookServiceImpl, languageServiceImpl));
        commands.put(UrlPath.ORDER_BOOK, new OrderBookCommand(bookServiceImpl, orderServiceImpl));
        commands.put(UrlPath.DELETE_ORDER, new DeleteOrderCommand(orderServiceImpl));
        commands.put(UrlPath.ADMIN_REFUSE_ORDER, new AdminRefuseOrderCommand(orderServiceImpl));
        commands.put(UrlPath.ADMIN_CONFIRM_ORDER, new AdminConfirmOrderCommand(orderServiceImpl));
        commands.put(UrlPath.ADMIN_RETURN_ORDER, new AdminReturnCommand(orderServiceImpl));
        commands.put(UrlPath.ADMIN_DELETE_BOOK, new AdminDeleteBookCommand(bookServiceImpl));
        commands.put(UrlPath.ADMIN_ADD_BOOK, new AdminAddBookCommand(bookServiceImpl, languageServiceImpl, authorServiceImpl, bookAttributeServiceImpl));
        commands.put(UrlPath.ADMIN_ADD_BOOK_PAGE, new AdminAddBookPageCommand());
    }

    public static CommandFactory getInstance() {
        if (instance == null)
            instance = new CommandFactory();
        return instance;
    }
    public Command getCommand(String key) {
        return commands.get(key);
    }
}
