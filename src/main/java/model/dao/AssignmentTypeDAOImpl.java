package model.dao;

import model.dao.interfaces.AssignmentTypeDAO;
import model.entity.AssignmentType;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentTypeDAOImpl implements AssignmentTypeDAO {
    private static Logger logger = Logger.getLogger(AssignmentTypeDAOImpl.class);
    private static final String FIND_BY_ID = "select * from assignment_type where id =?";
    private static final String FIND_ALL_TYPE = "select * from assignment_type";

    public AssignmentTypeDAOImpl() {
    }

    @Override
    public AssignmentType findById(int id) {
        AssignmentType assignment = null;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    assignment = new AssignmentType(resultSet.getInt("id"),
                            resultSet.getString("type"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find assignment type by id", e);
        }
        return assignment;
    }

    @Override
    public List<AssignmentType> findAllType() {
        List<AssignmentType> types = new ArrayList<>();
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_TYPE);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                AssignmentType assignment = new AssignmentType(id, type);
                types.add(assignment);
            }
        } catch (SQLException e) {
            logger.error("Can not find all Assignment types", e);
        }
        return types;
    }
}
