package utils;

import org.apache.commons.dbcp2.BasicDataSource;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class PoolConnections {
    private static final BasicDataSource connectionsPool = new BasicDataSource();
    private static final ResourceBundle resourceBundle =  ResourceBundle.getBundle("database");

    static {
        connectionsPool.setUrl(resourceBundle.getString("url"));
        connectionsPool.setUsername(resourceBundle.getString("user"));
        connectionsPool.setPassword(resourceBundle.getString("password"));
    }

    public PoolConnections() {
    }

    public static Connection getConnection() throws SQLException {
        return connectionsPool.getConnection();
    }
}
