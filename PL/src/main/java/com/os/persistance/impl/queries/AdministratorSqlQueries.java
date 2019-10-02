package com.os.persistance.impl.queries;

public class AdministratorSqlQueries {

    public static final String SELECT_ONE = "SELECT * FROM administrator WHERE id = ? ";

    public static final String SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM administrator " +
            "WHERE login = ? AND password = ? ";
}
