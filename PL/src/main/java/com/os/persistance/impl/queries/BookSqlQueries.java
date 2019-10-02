package com.os.persistance.impl.queries;

public class BookSqlQueries {

    private static final String LANGUAGE_ID = "AND languages.id = ? ";

    public static final String ORDER_BY_BOOKS_ID_DESC =
            "ORDER BY books.id DESC ";

    public static final String SELECT_ALL =
            "SELECT * FROM books, books_translate, authors, languages " +
                    "WHERE books.id = books_translate.book_id " +
                    "AND books_translate.author_id = authors.id " +
                    "AND languages.id = books_translate.language_id " +
                    "AND languages.id = authors.language_id ";

    public static final String SELECT_ALL_AVAILABLE = SELECT_ALL +
            "AND books.is_available = TRUE " +
            ORDER_BY_BOOKS_ID_DESC;

    public static final String SELECT_ALL_AVAILABLE_WITH_LANGUAGE = SELECT_ALL +
            "AND books.is_available = TRUE " +
            LANGUAGE_ID +
            ORDER_BY_BOOKS_ID_DESC;

    public static final String SELECT_ONE = SELECT_ALL + "AND books_translate.id = ? ";

    public static final String SELECT_ONE_WITH_LANGUAGE = SELECT_ALL + "AND books_translate.id = ? " + LANGUAGE_ID;

    public static final String SELECT_LAST_THREE = SELECT_ALL_AVAILABLE_WITH_LANGUAGE + " LIMIT 3 ";

    public static final String SELECT_BOOK_ATTRIBUTES =
            "SELECT * " +
                    "FROM attributes, books_attributes, books, books_translate, languages " +
                    "WHERE attributes.id = books_attributes.attribute_id " +
                    "AND books_translate.id = books_attributes.book_id " +
                    "AND attributes.language_id = languages.id " +
                    "AND books_translate.book_id = books.id " +
                    "AND books_attributes.book_id = ? ";

    public static final String SELECT_BOOK_ATTRIBUTES_WITH_LANGUAGE =
            "SELECT * " +
                    "FROM attributes, books_attributes, books, books_translate, languages " +
                    "WHERE attributes.id = books_attributes.attribute_id " +
                    "AND books_translate.id = books_attributes.book_id " +
                    "AND attributes.language_id = languages.id " +
                    "AND books_translate.book_id = books.id " +
                    "AND books_attributes.book_id = ? " + LANGUAGE_ID;

    public static final String DELETE = "DELETE FROM books, books_translate " +
            "WHERE books.id = books_translate.book_id AND books_translate.id = ?";

    public static final String CREATE = "INSERT INTO books, books_translate " +
            "(number_of_pages, is_available, address, publication_year, image)";

    public static final String UPDATE = "";

    public static String searchBooksTitleAndAuthorByParam(String searchParam){
        return  "SELECT DISTINCT * FROM books " +
                "LEFT JOIN books_translate ON books_translate.book_id = books.id " +
                "LEFT JOIN authors ON authors.id = books_translate.author_id " +
                "LEFT JOIN languages ON languages.id = books_translate.language_id " +
                "AND languages.id = authors.language_id WHERE " +
                "(" +
                "(books_translate.title LIKE '%" + searchParam + "%') " +
                "OR (authors.first_name LIKE '%" + searchParam + "%') " +
                "OR (authors.last_name LIKE '%" + searchParam + "%') " +
                ")";
    }

    public static String searchBookAttributesByBookId(String searchParam){
        return "SELECT DISTINCT * FROM books " +
                "LEFT JOIN books_translate ON books_translate.book_id = books.id " +
                "LEFT JOIN authors ON authors.id = books_translate.author_id " +
                "LEFT JOIN books_attributes ON books_attributes.book_id = books_translate.id " +
                "LEFT JOIN attributes ON books_attributes.attribute_id = attributes.id " +
                "LEFT JOIN languages ON languages.id = books_translate.language_id " +
                "AND languages.id = authors.language_id " +
                "AND languages.id = attributes.language_id " +
                "WHERE " +
                "(" +
                "( attributes.key_word LIKE '%" + searchParam + "%')" +
                ")";
    }



}
