package com.os.command;

import com.os.entity.Order;
import com.os.entity.Reader;
import com.os.enums.Status;
import com.os.service.impl.OrderServiceImpl;
import com.os.util.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrderCommand implements Command {
    private OrderServiceImpl orderServiceImpl;

    public DeleteOrderCommand(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));

        Order order = orderServiceImpl.getById(orderId);
        Reader reader = (Reader) request.getSession().getAttribute("readerSession");

        if(reader == null){
            response.sendRedirect("/library" + UrlPath.SIGN_IN);
        }
        else {

            if(order.getStatus() != Status.TAKEN_BY_READER) {
                orderServiceImpl.deleteOrder(order);
                response.sendRedirect("/library" + request.getParameter("from"));
            }
            else {
                response.sendRedirect("/library" + UrlPath.READER_PROFILE);
            }
        }
    }
}
