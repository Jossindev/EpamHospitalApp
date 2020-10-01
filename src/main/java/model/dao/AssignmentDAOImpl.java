package model.dao;

import model.entity.Assignment;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentDAOImpl implements model.dao.interfaces.AssignmentDAO {
    private static Logger logger = Logger.getLogger(AssignmentDAOImpl.class);
    private static final String FIND_BY_ID = "select * from assignment where id =?";
    private static final String UPDATE_EXECUTOR = "update assignment set executor_id = ? where id = ?";
    private static final String UPDATE_REPORTER = "update assignment set reporter_id = ? where id = ?";

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
            statement.executeQuery();
        } catch (SQLException e) {
            logger.error("Can not update assignment executor", e);
        }
    }

    @Override
    public void updateAssignmentReporter(int reporterId, int id) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_REPORTER)) {
            statement.setInt(1, reporterId);
            statement.setInt(2, id);
            statement.executeQuery();
        } catch (SQLException e) {
            logger.error("Can not update assignment reporter", e);
        }
    }
}
