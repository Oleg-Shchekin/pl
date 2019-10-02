package com.os.persistance.mapFunction;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T getFromResultSet(ResultSet resultSet) throws SQLException, IOException;
}
