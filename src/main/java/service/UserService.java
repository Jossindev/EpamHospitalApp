package service;

import exception.RuntimeSQLException;
import model.dao.UserDAOImpl;
import model.database.TransactionManager;
import model.entity.User;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

public class UserService {
    private static DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static UserDAOImpl userDao = daoFactory.createUserDao();

    public UserService() {

    }

    public void registerUser(User user) {
        try {
            user.setPassword(user.getPassword());
            TransactionManager.beginTransaction();
            userDao.addUser(user);
            TransactionManager.commitTransaction();
        } catch (RuntimeSQLException e) {
            e.printStackTrace();
            TransactionManager.rollbackTransaction();
            throw e;
        }
    }

    public User getUserById(int userId) {
        try {
            TransactionManager.beginTransaction();
            User user = userDao.findById(userId);
            TransactionManager.commitTransaction();
            return user;
        } catch (RuntimeSQLException e) {
            e.printStackTrace();
            TransactionManager.rollbackTransaction();
            throw e;
        }
    }

    public User signIn(String login, String password) {
            return userDao.findByEmailAndPass(login, password);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }


}
