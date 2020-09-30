import model.dao.repository.DoctorDAOImpl;
import model.dao.repository.UserDAOImpl;
import org.apache.log4j.BasicConfigurator;


public class Main {
    public static void main(String[] args) {
//        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
//        System.out.println(doctorDAO.findAllDoctors());
//        System.out.println(doctorDAO.findAllNurses());

        /* use for config logger*/
        BasicConfigurator.configure();

        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.findAll();
    }
}
