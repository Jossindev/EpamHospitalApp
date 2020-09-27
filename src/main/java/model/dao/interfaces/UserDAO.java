package model.dao.interfaces;

import model.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public User findByEmailAndPass(String email, String password);

    public void addUser(User user);

    public User findById(int id);
}
