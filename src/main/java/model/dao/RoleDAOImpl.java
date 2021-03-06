package model.dao;

import model.dao.interfaces.RoleDAO;
import model.entity.Role;
import model.database.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * The type Role dao.
 */
public class RoleDAOImpl implements RoleDAO {
    private static final Logger logger = Logger.getLogger(RoleDAOImpl.class);

    private static final String FIND_ROLE_BY_ID = "select * from role where id = ?";
    private static final String FIND_ROLE_BY_NAME = "select * from role where name = ?";

    /**
     * Instantiates a new Role dao.
     */
    public RoleDAOImpl() { }

    @Override
    public Role findById(int id) {
        Role role = null;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ROLE_BY_ID)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    role = new Role(resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find Role by Id ", e);
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        Role role = null;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ROLE_BY_NAME)) {
            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    role = new Role(resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find Role by name ", e);
        }
        return role;
    }
}
