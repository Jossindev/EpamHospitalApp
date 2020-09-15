package entity;

import utils.UserDataManipulation;

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
  //      this.role = userDataManipulation.detectRole(role);
    }

    public User (String name, String surname, String email, String password, int role) {
        userDataManipulation = new UserDataManipulation();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    //    this.role = userDataManipulation.detectRole(role);
    }

    public User (int id, String name, String surname, String email, String password, int role,UserDataManipulation userDataManipulations1) {
        userDataManipulation = userDataManipulations1;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
      //  this.role = userDataManipulation.detectRole(role);
    }

    public User (String name, String surname, String email, String password, int role,UserDataManipulation userDataManipulations1) {
        userDataManipulation = userDataManipulations1;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    //    this.role = userDataManipulation.detectRole(role);
    }



}
