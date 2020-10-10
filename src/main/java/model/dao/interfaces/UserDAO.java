package model.dao.interfaces;

import model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    public List<User> findAll();

    public Optional<User> findByEmailAndPass(String email, String password);

    public boolean addUser(User user);

    public Optional<User> findById(int id);
}
