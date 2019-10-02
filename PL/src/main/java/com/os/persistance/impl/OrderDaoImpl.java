package com.os.persistance.impl;

import com.os.entity.Order;
import com.os.factory.MapperFactory;
import com.os.persistance.impl.queries.OrderSqlQueries;
import com.os.persistance.interfaces.OrderDao;
import com.os.persistance.mapFunction.Mapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDaoImpl implements OrderDao {

    Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
    private Connection connection;
    Mapper<Order> orderMapper = MapperFactory.getInstance().getOrderMapper();

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Order> getByReaderId(int readerId) {
        List<Order> orders = new ArrayList<>();
        final ResultSet resultSet;
        String sql = OrderSqlQueries.SELECT_BY_READER_ID;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, readerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.getFromResultSet(resultSet));
                LOGGER.info("Order was created");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orders;
    }

    @Override
    public void create(Order object) {
        String sqlCreate = OrderSqlQueries.CREATE;
        String sqlUpdateBook = OrderSqlQueries.UPDATE_BOOK;

        try (PreparedStatement preparedStatementCreate = connection.prepareStatement(sqlCreate);
             PreparedStatement preparedStatementUpdateBook = connection.prepareStatement(sqlUpdateBook)) {

            preparedStatementCreate.setInt(1, object.getBook().getId());
            preparedStatementCreate.execute();

            preparedStatementUpdateBook.setInt(1, object.getReader().getId());
            preparedStatementUpdateBook.setInt(2, object.getBook().getId());
            preparedStatementUpdateBook.execute();

            LOGGER.info("Order was created");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Order getById(int id) {
        Order order = new Order.OrderBuilder().build();
        String sql = OrderSqlQueries.SELECT_ONE;
        final ResultSet resultSet;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = orderMapper.getFromResultSet(resultSet);
                LOGGER.info("Order was created");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String sql = OrderSqlQueries.SELECT_ALL;
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = orderMapper.getFromResultSet(resultSet);
                orders.add(order);
                LOGGER.info("Order was created");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orders;
    }

    @Override
    public void update(Order object) {
    }

    @Override
    public void updateStatus(Order object, String newStatus) {
        String sql = OrderSqlQueries.UPDATE_ORDER_STATUS;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, object.getId());
            preparedStatement.execute();
            LOGGER.info("Order was updated");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateStatusOrderRefuse(Order order) {
        String sql = OrderSqlQueries.UPDATE_ORDER_STATUS_REFUSE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, order.getId());
            preparedStatement.execute();
            LOGGER.info("Order was updated");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Order object) {
        String sqlDeleteOrder = OrderSqlQueries.DELETE;
        String sqlDeleteOrderUpdateBook = OrderSqlQueries.DELETE_ORDER_UPDATE_BOOK;

        try (PreparedStatement preparedStatementOrder = connection.prepareStatement(sqlDeleteOrder);
             PreparedStatement preparedStatementBook = connection.prepareStatement(sqlDeleteOrderUpdateBook)) {
            preparedStatementOrder.setInt(1, object.getId());
            preparedStatementBook.setInt(1, object.getBook().getId());

            preparedStatementOrder.execute();
            preparedStatementBook.execute();

            LOGGER.info("Order was deleted");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        try {
            LOGGER.info("Connection was closed");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
