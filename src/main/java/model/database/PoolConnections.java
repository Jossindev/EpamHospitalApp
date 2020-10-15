package model.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * The type Pool connections.
 */
public class PoolConnections {
    private static final HikariDataSource ds;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(resourceBundle.getString("url"));
        config.setUsername(resourceBundle.getString("user"));
        config.setPassword(resourceBundle.getString("password"));
        config.setMaximumPoolSize(15);
        config.setDriverClassName(resourceBundle.getString("driver"));

        ds = new HikariDataSource(config);
    }

    /**
     * Instantiates a new Pool connections.
     */
    public PoolConnections() { }

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws SQLException the sql exception
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
