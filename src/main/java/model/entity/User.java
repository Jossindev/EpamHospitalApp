package model.entity;

import model.dao.implementation.RoleDAOImpl;
import model.dao.interfaces.RoleDAO;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String email;
    private String password;
    private Role roleId;

    public User() {}
    public User(int id) {
        this.id = id;
    }

    public User(String name, String surname, Date birthday, String email, String password, Role roleId) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public User(int id, String name, String surname, Date birthday, String email, String password, int roleId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.roleId = detectRole(roleId);
    }

    public Role detectRole(int role) {
        return new RoleDAOImpl().findById(role);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Role getRoleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, email, password, roleId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleMap=" + roleId +
                '}';
    }
}
