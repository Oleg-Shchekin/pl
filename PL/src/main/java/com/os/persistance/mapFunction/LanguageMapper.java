package com.os.persistance.mapFunction;

import com.os.entity.Language;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageMapper implements Mapper<Language> {
    @Override
    public Language getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Language.LanguageBuilder()
                .setId(resultSet.getInt("languages.id"))
                .setLanguageName(resultSet.getString("languages.language_name"))
                .build();
    }
}
