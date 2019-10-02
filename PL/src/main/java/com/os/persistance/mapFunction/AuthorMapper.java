package com.os.persistance.mapFunction;

import com.os.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements Mapper<Author> {

    @Override
    public Author getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Author.AuthorBuilder()
                .setId(resultSet.getInt("authors.id"))
                .setFirstName(resultSet.getString("authors.first_name"))
                .setLastName(resultSet.getString("authors.last_name"))
                .setLanguage(new LanguageMapper().getFromResultSet(resultSet))
                .build();
    }
}
