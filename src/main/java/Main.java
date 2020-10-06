import model.dao.RoleDAOImpl;
import model.entity.Role;
import model.entity.User;
import org.apache.log4j.BasicConfigurator;
import service.impl.RoleService;
import service.impl.UserService;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {
        /* use for config logger*/
        BasicConfigurator.configure();

        UserService userService = new UserService();

        Role role1 = new RoleDAOImpl().findById(3);
        System.out.println(role1);
    }
}
