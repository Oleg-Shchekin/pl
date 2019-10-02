package com.os.servlet;

import com.os.entity.Book;
import com.os.factory.DaoFactory;
import com.os.persistance.impl.DaoFactoryImpl;
import com.os.persistance.interfaces.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewbook")
public class ImageServlet extends HttpServlet {
    public ImageServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = new DaoFactoryImpl();
        BookDao bookDao = daoFactory.createBookDao();

        List<Book> books = null;
        req.setAttribute("books", books);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
