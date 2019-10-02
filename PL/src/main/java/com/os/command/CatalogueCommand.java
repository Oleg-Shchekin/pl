package com.os.command;

import com.os.entity.Book;
import com.os.entity.Language;
import com.os.service.impl.BookServiceImpl;
import com.os.service.impl.LanguageServiceImpl;
import com.os.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogueCommand implements Command {
    private BookServiceImpl bookServiceImpl;
    private LanguageServiceImpl languageServiceImpl;

    public CatalogueCommand(BookServiceImpl bookServiceImpl, LanguageServiceImpl languageServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String locale = (String) request.getSession().getAttribute("locale");
        Language language = languageServiceImpl.getLanguageByName(locale);
        List<Book> books = bookServiceImpl.getAllAvailableBooksByLanguage(language);
        request.setAttribute("allBooks", books);
        request.getRequestDispatcher(Routes.CATALOGUE).forward(request, response);
    }
}
