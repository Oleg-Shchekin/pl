package com.os.command;

import com.os.entity.Order;
import com.os.entity.Reader;
import com.os.service.impl.OrderServiceImpl;
import com.os.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReaderProfileCommand implements Command{

    private OrderServiceImpl orderServiceImpl;

    public ReaderProfileCommand(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Reader reader = (Reader)request.getSession().getAttribute("readerSession");

        List<Order> orders = orderServiceImpl.getOrdersByReaderId(reader.getId());
        request.setAttribute("orders", orders);

        request.getRequestDispatcher(Routes.READER_PROFILE).forward(request, response);
    }
}
