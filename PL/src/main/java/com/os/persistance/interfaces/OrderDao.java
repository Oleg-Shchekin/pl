package com.os.persistance.interfaces;

import com.os.entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getByReaderId(int readerId);
    void updateStatus(Order order, String newStatus);

    void updateStatusOrderRefuse(Order order);
}
