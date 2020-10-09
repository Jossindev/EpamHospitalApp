package service.impl;

import model.dao.RoleDAOImpl;

import model.entity.Role;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

public class RoleService {
    private static DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static RoleDAOImpl roleDao = daoFactory.createRoleDao();

    public RoleService() {

    }

    public Role getRoleById(int roleId) {
           return roleDao.findById(roleId);
    }

    public Role getRoleByName(String roleName) { return roleDao.findByName(roleName); }

}
