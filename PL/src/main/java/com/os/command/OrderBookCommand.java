package com.os.command;

import com.os.entity.Book;
import com.os.entity.Order;
import com.os.entity.Reader;
import com.os.service.impl.BookServiceImpl;
import com.os.service.impl.OrderServiceImpl;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderBookCommand implements Command {
    private BookServiceImpl bookServiceImpl;
    private OrderServiceImpl orderServiceImpl;

    public OrderBookCommand(BookServiceImpl bookServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int book_id = Integer.parseInt(request.getParameter("book_id"));

        Book book = bookServiceImpl.getBookById(book_id);
        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader == null){
            response.sendRedirect("/library" + UrlPath.SIGN_IN_PAGE);
        }
        else {
            Order order = new Order.OrderBuilder()
                    .setReader(reader)
                    .setBook(book)
                    .build();
            orderServiceImpl.createOrder(order);

            response.sendRedirect("/library" + request.getParameter("from"));
        }
    }
}
