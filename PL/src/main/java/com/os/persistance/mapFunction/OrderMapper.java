package com.os.persistance.mapFunction;


import com.os.entity.Order;
import com.os.enums.Status;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements Mapper<Order>{
    @Override
    public Order getFromResultSet(ResultSet resultSet) throws SQLException, IOException {
        return new Order.OrderBuilder()
                .setId(resultSet.getInt("orders.id"))
                .setBook(new BookMapper().getFromResultSet(resultSet))
                .setReader(new ReaderMapper().getFromResultSet(resultSet))
                .setTime(resultSet.getTime("orders.time"))
                .setStatus(Status.valueOf(resultSet.getString("orders.status")))
                .build();
    }
}
