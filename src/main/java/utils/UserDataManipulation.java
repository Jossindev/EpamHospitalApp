package utils;

import entity.Role;
import implementation.RoleDAOImpl;
import implementation.UserDAOImpl;
import utils.factory.DAOFactory;

public class UserDataManipulation {

    DAOFactory factory;

    UserDAOImpl userDAO;

    RoleDAOImpl roleDAO;


    public UserDataManipulation() {
        this.factory = new DAOFactory();
        userDAO = factory.createUserDao();
        roleDAO = factory.createRoleDao();
    }

    public UserDataManipulation (DAOFactory factory) {
        this.factory = factory;
        userDAO = factory.createUserDao();
        roleDAO = factory.createRoleDao();
    }

    public Role detectRole(int id) {
        return roleDAO.findById(id);
    }
}
