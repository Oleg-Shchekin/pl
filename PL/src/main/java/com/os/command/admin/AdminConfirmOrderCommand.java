package com.os.command.admin;

import com.os.command.Command;
import com.os.entity.Order;
import com.os.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminConfirmOrderCommand implements Command {
    private OrderServiceImpl orderServiceImpl;

    public AdminConfirmOrderCommand(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderServiceImpl.getById(orderId);
        String status = String.valueOf(order.getStatus());


        orderServiceImpl.updateStatus(order, changeStatus(status));

        response.sendRedirect("/library" + request.getParameter("from"));
    }

    private String changeStatus(String status) {
        String newStatus = null;
        switch (status) {
            case "UNCONFIRMED":
                newStatus = "CONFIRMED";
                break;
            case "CONFIRMED":
                newStatus = "TAKEN_BY_READER";
                break;
            case "REFUSED":
                newStatus = "CONFIRMED";
        }
        return newStatus;
    }

}
