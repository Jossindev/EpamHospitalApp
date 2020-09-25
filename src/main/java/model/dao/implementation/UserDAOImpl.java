package model.dao.implementation;

import model.dao.interfaces.UserDAO;
import model.entity.User;
import org.apache.log4j.Logger;
import utils.PoolConnections;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static Logger logger = Logger.getLogger(UserDAOImpl.class);

    public UserDAOImpl() {
    }

    @Override
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

                User user = new User(id, name, surname, birthday, email, pass, role);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Can not find all users ", e);
        }
        return users;
    }

    @Override
    public User findByNameEmailAndPass(String name, String email, String password) {
        User user = null;
        String sql = "select * from user where name = ? and email = ? and password = ?";

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getDate("birthday"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find by name and email ", e);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into  user(name, surname, birthday, email, password, role_id)  " +
                "values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = PoolConnections.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setDate(3, user.getBirthday());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRoleId().getId());
            statement.execute();
        } catch (SQLException e) {
            logger.error("Can not insert into user table ", e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        String sql = "select * from user where id =?";
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getDate("birthday"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find by id ", e);
        }
        return user;
    }
}
