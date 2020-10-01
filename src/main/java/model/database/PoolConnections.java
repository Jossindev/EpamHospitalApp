package model.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PoolConnections {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");

    static {
        config.setJdbcUrl(resourceBundle.getString("url"));
        config.setUsername(resourceBundle.getString("user"));
        config.setPassword(resourceBundle.getString("password"));
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public PoolConnections() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
