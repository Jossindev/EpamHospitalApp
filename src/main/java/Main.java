import model.dao.implementation.RoleDAOImpl;
import model.dao.implementation.UserDAOImpl;

public class Main {
    public static void main(String[] args) {

        UserDAOImpl users = new UserDAOImpl();
        System.out.println(users.findAll());

    }
}
