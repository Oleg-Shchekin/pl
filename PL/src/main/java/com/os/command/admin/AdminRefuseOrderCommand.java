package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Order;
import com.os.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminRefuseOrderCommand implements Command {
    private OrderServiceImpl orderServiceImpl;

    public AdminRefuseOrderCommand(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderServiceImpl.getById(orderId);

        orderServiceImpl.updateStatusOrderRefuse(order);

        response.sendRedirect("/library" + request.getParameter("from"));

    }
}
