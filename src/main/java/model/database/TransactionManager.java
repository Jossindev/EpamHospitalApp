package model.database;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private TransactionManager() {

    }

    public static void beginTransaction() {
        try {
            PoolConnections.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackTransaction() {
        try {
            Connection connection = PoolConnections.getConnection();
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commitTransaction() {
        try {
            Connection connection = PoolConnections.getConnection();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
