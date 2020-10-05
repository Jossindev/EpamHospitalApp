package model.database;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnections {
    private static BasicDataSource ds = new BasicDataSource();
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    static {
        ds.setUrl(resourceBundle.getString("url"));
        ds.setUsername(resourceBundle.getString("user"));
        ds.setPassword(resourceBundle.getString("password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public PoolConnections() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
