package com.os.service.impl;

import com.os.entity.Order;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.OrderDao;
import com.os.persistance.poolConnection.TransactionManager;

import java.util.List;

public class OrderServiceImpl {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders(){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getAll();
        }
    }

    public List<Order> getOrdersByReaderId(int readerId){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getByReaderId(readerId);
        }
    }

    public void createOrder(Order order){
        TransactionManager.getInstance().beginTransaction();
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.create(order);
            if (order != null){
                TransactionManager.getInstance().commit();
            }else {
                TransactionManager.getInstance().rollback();
            }
        }
    }

    public void deleteOrder(Order order){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.delete(order);
        }
    }

    public Order getById(int id){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            return orderDao.getById(id);
        }
    }

    public void updateStatus(Order order, String newStatus){
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.updateStatus(order, newStatus);
        }
    }

    public void updateStatusOrderRefuse(Order order) {
        try(OrderDao orderDao = daoFactory.createOrderDao()){
            orderDao.updateStatusOrderRefuse(order);
        }
    }
}