package model.dao.implementation;

import model.entity.Role;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl {
  public RoleDAOImpl() {}

  public Role findById(int id) {
    Role role = null;
    String sql = "select * from role where id = ?";

    try(Connection connection = PoolConnections.getConnection()) {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        role = new Role(resultSet.getInt("id"),
                resultSet.getString("name"));
      }
    } catch (SQLException throwables) {

    }
    return role;
  }
}
