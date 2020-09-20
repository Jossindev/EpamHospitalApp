package entity;

import utils.data.UserDataManipulation;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

    UserDataManipulation userDataManipulation;

    public User (int id, String name, String surname, String email, String password, int role) {
        userDataManipulation = new UserDataManipulation();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = userDataManipulation.detectRole(role);
    }

    public User (String name, String surname, String email, String password, int role) {
        userDataManipulation = new UserDataManipulation();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = userDataManipulation.detectRole(role);
    }

    public User (int id, String name, String surname, String email, String password, int role,UserDataManipulation userDataManipulations1) {
        userDataManipulation = userDataManipulations1;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = userDataManipulation.detectRole(role);
    }

    public User (String name, String surname, String email, String password, int role,UserDataManipulation userDataManipulations1) {
        userDataManipulation = userDataManipulations1;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = userDataManipulation.detectRole(role);
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

    public void setRole(Role role) {
        this.role = role;
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

    public Role getRole() {
        return role;
    }
}
