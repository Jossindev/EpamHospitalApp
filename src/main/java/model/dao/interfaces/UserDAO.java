package model.dao.interfaces;

import model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface User dao.
 */
public interface UserDAO {
    /**
     * Find all list.
     *
     * @return the list
     */
    public List<User> findAll();

    /**
     * Find by email and pass optional.
     *
     * @param email    the email
     * @param password the password
     * @return the optional
     */
    public Optional<User> findByEmailAndPass(String email, String password);

    /**
     * Add user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean addUser(User user);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<User> findById(int id);
}
