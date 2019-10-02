package com.os.persistance.mapFunction;

import com.os.entity.BookAttribute;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAttributeMapper implements Mapper<BookAttribute> {
    @Override
    public BookAttribute getFromResultSet(ResultSet resultSet) throws SQLException {
        return new BookAttribute.BookAttributeBuilder()
                .setId(resultSet.getInt("attributes.id"))
                .setKeyWord(resultSet.getString("key_word"))
                .setLanguage(new LanguageMapper().getFromResultSet(resultSet))
                .build();
    }
}
