package com.os.persistance.impl;

import com.os.entity.Author;
import com.os.factory.MapperFactory;
import com.os.persistance.impl.queries.AuthorSqlQueries;
import com.os.persistance.interfaces.AuthorDao;
import com.os.persistance.mapFunction.Mapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private Connection connection;
    Mapper<Author> authorMapper = MapperFactory.getInstance().getAuthorMapper();

    public AuthorDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Author object) {
        String sql = AuthorSqlQueries.CREATE;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setInt(3, object.getLanguage().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Author getById(int id) {
        Author author = new Author.AuthorBuilder().build();
        String sql = AuthorSqlQueries.SELECT_ONE;
        final ResultSet resultSet;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                 author = authorMapper.getFromResultSet(resultSet);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return author;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        final ResultSet resultSet;
        String sql = AuthorSqlQueries.SELECT_ALL;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                authors.add(authorMapper.getFromResultSet(resultSet));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return authors;
    }

    @Override
    public void update(Author object) {

    }

    @Override
    public void delete(Author object) {

    }

    @Override
    public void close() {
        try{
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
