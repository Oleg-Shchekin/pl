package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Book;
import com.os.entity.Order;
import com.os.service.impl.BookServiceImpl;
import com.os.service.impl.OrderServiceImpl;
import com.os.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminShowAllBooksCommand implements Command {
    private BookServiceImpl bookServiceImpl;
    private OrderServiceImpl orderServiceImpl;

    public AdminShowAllBooksCommand(BookServiceImpl bookServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookServiceImpl.getAllAvailableBooks();
        List<Order> orders = orderServiceImpl.getAllOrders();

        request.setAttribute("books", books);
        request.setAttribute("orders", orders);

        request.getRequestDispatcher(Routes.ADMIN_SHOW_ALL_BOOKS).forward(request, response);
    }
}
