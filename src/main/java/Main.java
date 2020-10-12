import model.entity.Doctor;
import model.entity.Patient;
import service.impl.PatientService;


import java.util.Comparator;
import java.util.List;


public class Main {
     static Comparator<Doctor> SORT_DOCTOR_BY_ALPHABET =  (o1, o2) -> o1.getUserId().getName().compareTo(o2.getUserId().getName());
     static Comparator<Doctor> SORT_DOCTOR_BY_TYPE = (o1, o2) -> o1.getDoctorType().compareTo(o2.getDoctorType());

     static Comparator<Patient> SORT_PATIENTS_BY_ALPHABET =  (o1, o2) -> o1.getUser().getName().compareTo(o2.getUser().getName());
     static Comparator<Patient> SORT_PATIENTS_BY_DATE =  (o1, o2) -> o1.getUser().getBirthday().compareTo(o2.getUser().getBirthday());

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.findAll();
        for (Patient patient : patients) {
            System.out.println(patient.getUser().getName());
            System.out.println(patient.getUser().getBirthday());
        }
        patients.sort(SORT_PATIENTS_BY_DATE);

        for (Patient patient : patients) {
            System.out.println(patient.getUser().getName());
            System.out.println(patient.getUser().getBirthday());
        }
    }

}
