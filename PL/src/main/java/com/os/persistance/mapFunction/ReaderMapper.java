package com.os.persistance.mapFunction;

import com.os.entity.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderMapper implements Mapper<Reader> {
    @Override
    public Reader getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Reader.ReaderBuilder()
                .setId(resultSet.getInt("readers.id"))
                .setEmail(resultSet.getString("readers.email"))
                .setPassword(resultSet.getString("readers.password"))
                .setTelephoneNumber(resultSet.getString("readers.telephone_number"))
                .setFirstName(resultSet.getString("readers.first_name"))
                .setLastName(resultSet.getString("readers.last_name"))
                .build();
    }
}
