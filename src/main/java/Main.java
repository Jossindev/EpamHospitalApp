
import model.dao.repository.UserDAOImpl;
import model.entity.User;


public class Main {
    public static void main(String[] args) {

        UserDAOImpl users = new UserDAOImpl();
        System.out.println(users.findAll());
       User user = users.findByNameEmailAndPass("patient1","patient1@gmail.com","1111");
        System.out.println(user);
//       User user2 = new User("name1","surname1",new Date(2020-01-01),
//               "email","pass",new User().detectRole(1));
//        users.insert(user);
//        DiagnosisDAOImpl d = new DiagnosisDAOImpl();
//        Diagnosis diagnosis =  d.findById(1);
//        System.out.println(diagnosis);
//        System.out.println(d.findAll());

        TreatmentDAOImpl treatmentDAO = new TreatmentDAOImpl();
      System.out.println(treatmentDAO.findDoctorById(5));
      System.out.println(treatmentDAO.findDoctorPatients(5));
      System.out.println(treatmentDAO.findPatientsWhereNoNurse());
        System.out.println(treatmentDAO.findPatientsWhereNoDoctor());
        treatmentDAO.updatePatientDiagnosis(1,3);

    }
}
