package model.dao;

import model.dao.interfaces.UserDAO;
import model.entity.User;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type User dao.
 */
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    private final static String FIND_BY_ID = "select * from user where id =?";
    private final static String FIND_ALL = "select * from user";
    private final static String FIND_BY_EMAIL_AND_PASS = "select * from user where email = ? and password = ?";
    private final static String INSERT_USER = "insert into user(name, surname, birthday, email, password, role_id)  " +
            "values (?, ?, ?, ?, ?, ?)";

    /**
     * Instantiates a new User dao.
     */
    public UserDAOImpl() {
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
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
    public boolean addUser(User user) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setDate(3, user.getBirthday());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRoleId().getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.error("Can not insert into user table ", e);
        }
        return false;
    }

    @Override
    public Optional<User> findByEmailAndPass(String email, String password) {
        User user;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASS)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getDate("birthday"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getInt("role_id"));
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find by name and email ", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(int id) {
        User user;
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {

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
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find by id ", e);
        }
        return Optional.empty();
    }
}
