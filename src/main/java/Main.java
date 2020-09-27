import model.dao.repository.DoctorDAOImpl;


public class Main {
    public static void main(String[] args) {
        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
        System.out.println(doctorDAO.findAllDoctors());
        System.out.println(doctorDAO.findAllNurses());
    }
}
