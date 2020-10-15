package model.dao.interfaces;

import model.entity.Role;

/**
 * The interface Role dao.
 */
public interface RoleDAO {
    /**
     * Find by id role.
     *
     * @param id the id
     * @return the role
     */
    public Role findById(int id);

    /**
     * Find by name role.
     *
     * @param name the name
     * @return the role
     */
    public Role findByName(String name);
}
