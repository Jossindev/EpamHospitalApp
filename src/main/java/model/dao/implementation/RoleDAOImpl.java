package model.dao.implementation;

import model.dao.interfaces.RoleDAO;
import model.entity.Role;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class RoleDAOImpl implements RoleDAO {
    public RoleDAOImpl() {
    }

    private static final Logger logger = Logger.getLogger(RoleDAOImpl.class);

    @Override
    public Role findById(int id) {
        Role role = null;
        String sql = "select * from role where id = ?";

        try (Connection connection = PoolConnections.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            logger.error("Can not find Role by Id ", e);
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        Role role = null;
        String sql = "select * from role where name = ?";
        try (Connection connection = PoolConnections.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            logger.error("Can not find Role by name ", e);
        }
        return role;
    }
}
