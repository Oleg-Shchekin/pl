package com.os.persistance.poolConnection;

import org.apache.log4j.Logger;

import java.sql.SQLException;


public class TransactionManager {
    private static final Logger LOGGER = Logger.getLogger(TransactionManager.class);

    private ConnectionPoolHolder pool = ConnectionPoolHolder.getInstance();
    private final ThreadLocal<ConnectionWrapper> currentConnection = new ThreadLocal<>();

    private static TransactionManager instance = new TransactionManager();
    private static final String dbConnError = "Database connection error";

    private TransactionManager(){}

    public static TransactionManager getInstance(){return instance;}

    public ConnectionWrapper getConnectionWrapper(){
        if (currentConnection.get() == null){
            return new ConnectionWrapper(pool.getConnection());
        }else {
            return provideConnection();
        }
    }
    public void beginTransaction(){
        if (currentConnection.get() != null){
            throw new IllegalStateException();
        }
        provideConnection();
    }
    public void commit() {

        if (currentConnection.get() == null) {
            throw new IllegalStateException();
        }
        LOGGER.debug("before commit");

        try {
            currentConnection.get().commit();

            LOGGER.debug("after commit");
        } catch (SQLException e) {
            LOGGER.error(dbConnError + e);
            try {
                LOGGER.error("Transaction is being rolled back");
                currentConnection.get().rollback();
            } catch (SQLException e1) {
                LOGGER.error("Failed to rollback dao.transaction \n" + e1);
            }
        } finally {
            try {
                currentConnection.get().setTransactionActive(false);
                currentConnection.get().setAutoCommit(true);
                currentConnection.get().close();
            } catch (SQLException e) {
                LOGGER.error(dbConnError + e);
            }
        }

        currentConnection.set(null);
    }
    public void rollback(){
        try {
            currentConnection.get().rollback();
            currentConnection.get().close();
            currentConnection.remove();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }
    //provide connection for current dao.transaction or create if not exist
    public ConnectionWrapper provideConnection(){
        if (currentConnection.get() != null){
            return currentConnection.get();
        }
        currentConnection.set(new ConnectionWrapper(pool.getConnection()));
        currentConnection.get().setTransactionActive(true);
        try {
            currentConnection.get().setAutoCommit(false);
        }catch (SQLException e){
            LOGGER.error(dbConnError +e);
        }
        return currentConnection.get();
    }
}
