package com.os.command;

import com.os.entity.Book;
import com.os.service.impl.BookServiceImpl;
import com.os.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchCommand implements Command {
    private BookServiceImpl bookServiceImpl;

    public SearchCommand(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchParam = request.getParameter("search_param");
        request.setAttribute("search_param", searchParam);
        List<Book> books = bookServiceImpl.getBooksSearchByParam(searchParam);
        request.setAttribute("search_size", books.size());
        request.setAttribute("booksSearchByParam", books);
        request.getRequestDispatcher(Routes.SEARCH).forward(request, response);
    }
}
