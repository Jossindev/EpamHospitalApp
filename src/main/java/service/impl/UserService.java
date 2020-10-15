package service.impl;

import model.dao.UserDAOImpl;
import model.entity.User;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 */
public class UserService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final UserDAOImpl userDao = daoFactory.createUserDao();

    /**
     * Instantiates a new User service.
     */
    public UserService() { }

    /**
     * Register user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean registerUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * Sign in optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional
     */
    public Optional<User> signIn(String login, String password) {
        return userDao.findByEmailAndPass(login, password);
    }

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    public Optional<User> getUserById(int userId) {
        return userDao.findById(userId);
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
