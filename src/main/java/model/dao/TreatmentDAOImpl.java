package model.dao;

import model.entity.Treatment;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Treatment dao.
 */
public class TreatmentDAOImpl implements model.dao.interfaces.TreatmentDAOImpl {
    private static final Logger logger = Logger.getLogger(TreatmentDAOImpl.class);

    private static final String FIND_BY_ID = "select * from treatment where id = ?";

    /**
     * Instantiates a new Treatment dao.
     */
    public TreatmentDAOImpl() { }

    @Override
    public Treatment findById(int id) {
        Treatment treatment = null;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    treatment = new Treatment(resultSet.getInt("id"),
                            resultSet.getInt("assignment_id"),
                            resultSet.getString("diagnosis"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find treatment by ID", e);
        }
        return treatment;
    }
}
