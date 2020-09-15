package implementation;

import entity.Role;
import entity.User;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl {

    public Role findById(int id) {
        Role role = null;

        try(Connection connection =  PoolConnections.getConnection()) {
            String FIND_BY_ID = "select * from roles where role_id = ?";
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new Role(resultSet.getInt("role_id"),
                        resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            System.out.println("Error");
        }
        return role;
    }
}
