package model.dao.implementation;

import model.entity.User;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAOImpl {
    public UserDAOImpl() {
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");
                String pass = resultSet.getString("password");
                int role = resultSet.getInt("role_id");

                User user = new User(id,name,surname,birthday,email,pass,role);
                users.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return users;
    }
}
