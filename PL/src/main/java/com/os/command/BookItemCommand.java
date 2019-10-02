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

public class BookItemCommand implements Command {
    private BookServiceImpl bookServiceImpl;
    private LanguageServiceImpl languageServiceImpl;

    public BookItemCommand(BookServiceImpl bookServiceImpl, LanguageServiceImpl languageServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.languageServiceImpl = languageServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String locale = (String) request.getSession().getAttribute("locale");
        Language language = languageServiceImpl.getLanguageByName(locale);

        int id = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookServiceImpl.getBookByIdAndLanguage(id, language);

        request.setAttribute("book", book);

        request.getRequestDispatcher(Routes.BOOK_ITEM).forward(request, response);

    }
}
