package com.os.persistance.impl;

import com.os.entity.Language;
import com.os.factory.MapperFactory;
import com.os.persistance.impl.queries.LanguageSqlQueries;
import com.os.persistance.interfaces.LanguageDao;
import com.os.persistance.mapFunction.Mapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LanguageDaoImpl implements LanguageDao {
    private Connection connection;
    Mapper<Language> languageMapper = MapperFactory.getInstance().getLanguageMapper();

    public LanguageDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Language getLanguageByLanguageName(String languageName) {
        String sql = LanguageSqlQueries.SELECT_LANGUAGE_BY_NAME;
        final ResultSet resultSet;
        Language language = new Language.LanguageBuilder().build();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, languageName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                language = languageMapper.getFromResultSet(resultSet);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return language;
    }

    @Override
    public void create(Language object) {

    }

    @Override
    public Language getById(int id) {
        return null;
    }

    @Override
    public List<Language> getAll() {
        return null;
    }

    @Override
    public void update(Language object) {

    }

    @Override
    public void delete(Language object) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
