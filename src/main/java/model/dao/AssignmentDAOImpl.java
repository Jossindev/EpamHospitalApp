package model.dao;

import model.entity.Assignment;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Assignment dao.
 */
public class AssignmentDAOImpl implements model.dao.interfaces.AssignmentDAO {
    private static final Logger logger = Logger.getLogger(AssignmentDAOImpl.class);

    private static final String FIND_BY_ID = "select * from assignment where id =?";
    private static final String UPDATE_EXECUTOR = "update assignment set executor_id = ? where id = ?";
    private static final String UPDATE_REPORTER = "update assignment set reporter_id = ?, description = ? where id = ?";

    /**
     * Instantiates a new Assignment dao.
     */
    public AssignmentDAOImpl() {
    }

    @Override
    public Assignment findById(int id) {
        Assignment assignment = null;
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    assignment = new Assignment(resultSet.getInt("id"),
                            resultSet.getInt("executor_id"),
                            resultSet.getInt("reporter_id"),
                            resultSet.getString("description"),
                            resultSet.getInt("type_id"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find by Id", e);
        }
        return assignment;
    }

    @Override
    public void updateAssignmentExecutor(int executorId, int id) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EXECUTOR)) {
            statement.setInt(1, executorId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update assignment executor", e);
        }
    }

    @Override
    public void updateAssignmentReporter(int reporterId, int id, String description) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_REPORTER)) {
            statement.setInt(1, reporterId);
            statement.setString(2,description);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update assignment reporter", e);
        }
    }
}
