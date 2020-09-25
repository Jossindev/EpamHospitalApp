package model.dao.interfaces;

import model.entity.Role;

public interface RoleDAO {
    public Role findById(int id);
    public Role findByName(String name);
}
