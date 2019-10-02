package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Book;
import com.os.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminDeleteBookCommand implements Command {
    private BookServiceImpl bookServiceImpl;

    public AdminDeleteBookCommand(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookServiceImpl.getBookById(bookId);

        bookServiceImpl.deleteBook(book);

        response.sendRedirect("/library" + request.getParameter("from"));
    }
}
