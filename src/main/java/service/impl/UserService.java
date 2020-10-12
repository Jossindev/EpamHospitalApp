package service.impl;

import model.dao.UserDAOImpl;
import model.entity.User;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;
import java.util.Optional;

public class UserService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final UserDAOImpl userDao = daoFactory.createUserDao();

    public UserService() { }

    public boolean registerUser(User user) {
        return userDao.addUser(user);
    }

    public Optional<User> signIn(String login, String password) {
        return userDao.findByEmailAndPass(login, password);
    }

    public Optional<User> getUserById(int userId) {
        return userDao.findById(userId);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }


}
