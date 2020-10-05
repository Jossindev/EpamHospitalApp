package service;

import exception.RuntimeSQLException;
import model.dao.RoleDAOImpl;
import model.dao.UserDAOImpl;
import model.database.TransactionManager;
import model.entity.Role;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

public class RoleService {
    private static DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static RoleDAOImpl roleDao = daoFactory.createRoleDao();

    public RoleService() {

    }

    public static Role getRoleById(int roleId) {
        try {
            TransactionManager.beginTransaction();
            Role role = roleDao.findById(roleId);
            TransactionManager.commitTransaction();
            return role;
        } catch (RuntimeSQLException e) {
            e.printStackTrace();
            TransactionManager.rollbackTransaction();
            throw e;
        }
    }

    public static Role getRoleByName(String roleName) {
        try {
            TransactionManager.beginTransaction();
            Role role = roleDao.findByName(roleName);
            TransactionManager.commitTransaction();
            return role;
        } catch (RuntimeSQLException e) {
            e.printStackTrace();
            TransactionManager.rollbackTransaction();
            throw e;
        }
    }
}
