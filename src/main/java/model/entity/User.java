package model.entity;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private String password;
    private Map<Integer, Role> roleMap;

    public User() {}
    public User(int id) {
        this.id = id;
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

    public void setRoleMap(Map<Integer, Role> roleMap) {
        this.roleMap = roleMap;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Map<Integer, Role> getRoleMap() {
        return roleMap;
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
                Objects.equals(roleMap, user.roleMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, email, password, roleMap);
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
                ", roleMap=" + roleMap +
                '}';
    }
}
