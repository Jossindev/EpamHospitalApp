import utils.PoolConnections;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            PoolConnections.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
