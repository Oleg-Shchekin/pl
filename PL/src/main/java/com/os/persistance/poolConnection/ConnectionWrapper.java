package com.os.persistance.poolConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionWrapper implements AutoCloseable{
    private boolean transactionActive;
    private Connection connection;


    public ConnectionWrapper (Connection connection){ this.connection = connection;}

    public boolean isTransactionActive() {
        return transactionActive;
    }

    public void setTransactionActive(boolean transactionActive) {
        this.transactionActive = transactionActive;
    }
    public void setAutoCommit(boolean autoCommit) throws SQLException{
        connection.setAutoCommit(autoCommit);
    }
    public void commit () throws SQLException{
        connection.commit();
    }
    public void rollback() throws SQLException{
        connection.rollback();
    }
    public void close() throws SQLException{
        if (!isTransactionActive()){
            connection.close();
        }
    }
    public PreparedStatement prepareStatement(String sql, int returnGeneratedKeys) throws SQLException {
        return this.connection.prepareStatement(sql, returnGeneratedKeys);

    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);

    }

    public Statement createStatement() throws SQLException {
        return this.connection.createStatement();
    }
}
