package service.impl;

import model.dao.RoleDAOImpl;
import model.entity.Role;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

/**
 * The type Role service.
 */
public class RoleService {
    private static DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static RoleDAOImpl roleDao = daoFactory.createRoleDao();

    /**
     * Instantiates a new Role service.
     */
    public RoleService() { }

    /**
     * Gets role by id.
     *
     * @param roleId the role id
     * @return the role by id
     */
    public Role getRoleById(int roleId) {
        return roleDao.findById(roleId);
    }

    /**
     * Gets role by name.
     *
     * @param roleName the role name
     * @return the role by name
     */
    public Role getRoleByName(String roleName) {
        return roleDao.findByName(roleName);
    }

}
