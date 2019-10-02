package com.os.persistance.impl.queries;

public class OrderSqlQueries {
    public static final String SELECT_ALL = "SELECT * FROM books, books_translate, authors, languages, orders, readers " +
            "WHERE books.id = books_translate.book_id " +
            "AND books_translate.author_id = authors.id " +
            "AND languages.id = books_translate.language_id " +
            "AND languages.id = authors.language_id " +
            "AND orders.book_id = books_translate.id " +
            "AND books.reader_id = readers.id ";

    public static final String SELECT_ONE = SELECT_ALL + "AND orders.id = ?";

    public static final String SELECT_BY_READER_ID = SELECT_ALL + "AND books.reader_id = ?";

    public static final String CREATE = "INSERT INTO orders (orders.book_id, orders.status) VALUES (?, 'UNCONFIRMED')";

    public static final String UPDATE_BOOK = "UPDATE books, books_translate " +
            "SET books.is_available=false, books.reader_id = ? " +
            "WHERE books.id = books_translate.book_id AND books_translate.id = ?";

    public static final String DELETE = "DELETE FROM orders WHERE orders.id = ?";

    public static final String DELETE_ORDER_UPDATE_BOOK = "UPDATE books, books_translate " +
            "SET books.is_available=true, books.reader_id = null " +
            "WHERE books.id = books_translate.book_id AND books_translate.id = ?";

    public static final String UPDATE_ORDER_STATUS = "UPDATE orders " +
            "SET orders.status = ? " +
            "WHERE orders.id = ? ";

    public static final String UPDATE_ORDER_STATUS_REFUSE = "UPDATE orders " +
            "SET orders.status = 'REFUSED' " +
            "WHERE orders.id = ? ";
}
