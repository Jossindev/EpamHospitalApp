
import model.dao.implementation.UserDAOImpl;
import model.entity.User;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        UserDAOImpl users = new UserDAOImpl();
        System.out.println(users.findAll());
       User user = users.findByNameEmailAndPass("patient1","patient1@gmail.com","1111");
        System.out.println(user);
//       User user2 = new User("name1","surname1",new Date(2020-01-01),
//               "email","pass",new User().detectRole(1));
//        users.insert(user);


    }
}
