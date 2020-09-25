package model.dao.interfaces;

import model.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findByNameEmailAndPass(String name, String email, String password);

    public void insert(User user);

    public User findById(int id);
}
