package com.os.persistance.impl.queries;

public class BookAttributeSqlQueries {
    public static final String SELECT_ALL = "SELECT * FROM attributes, languages " +
            "WHERE language_id = languages.id;";
    public static final String SELECT_ONE = "SELECT * FROM attributes, languages " +
            "WHERE language_id = language.id AND attributes.id = ?;";
    public static final String SELECT_ALL_BY_BOOK_ID = "SELECT * FROM attributes, books_attributes, languages " +
            "WHERE language_id = languages.id AND attribute_id = attributes.id AND book_id = ?;";

    public static String searchBookAttributesByBookId(String searchParam){
        return "SELECT * FROM attributes " +
                "LEFT JOIN books_attributes ON books_attributes.attribute_id = attributes.id " +
                "LEFT JOIN languages ON attributes.language_id = languages.id " +
                "WHERE " +
                "(" +
                "(attributes.key_word LIKE '%" + searchParam + "%')" +
                ");";
    }

    public static final String CREATE = "INSERT INTO attributes, books_attributes " +
            "(attributes.key_word, attributes.language.id, books_attributes.book_id, books_attributes.attribute_id) " +
            "VALUES (?,?,?,?) ";
}
