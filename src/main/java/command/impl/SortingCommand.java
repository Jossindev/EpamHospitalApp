package command.impl;

import command.HospitalCommand;
import model.entity.Doctor;
import model.entity.Patient;
import service.impl.DoctorService;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;


import static constant.HospitalPages.ADMIN_HOME;

/**
 * The type Sorting command.
 */
public class SortingCommand implements HospitalCommand {
    private static final Comparator<Doctor> SORT_DOCTOR_BY_ALPHABET = (o1, o2) -> o1.getUserId().getName().compareTo(o2.getUserId().getName());
    private static final Comparator<Doctor> SORT_DOCTOR_BY_TYPE = Comparator.comparing(Doctor::getDoctorType);

    private static final Comparator<Patient> SORT_PATIENTS_BY_ALPHABET = (o1, o2) -> o1.getUser().getName().compareTo(o2.getUser().getName());
    private static final Comparator<Patient> SORT_PATIENTS_BY_DATE = (o1, o2) -> o1.getUser().getBirthday().compareTo(o2.getUser().getBirthday());

    private static final String activeDoctors = "activeDoctors";
    private static final String activePatients = "activePatients";
    private static final String isSorted = "isSorted";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        HttpSession session = request.getSession();

        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.findAll();

        DoctorService service = new DoctorService();
        List<Doctor> doctors = service.findAllDoctors();

        switch (type) {
            case 1:
                doctors.sort(SORT_DOCTOR_BY_ALPHABET);
                request.setAttribute(activeDoctors, doctors);
                request.setAttribute(activePatients, patients);
                session.setAttribute(isSorted,"true");
                break;
            case 2:
                doctors.sort(SORT_DOCTOR_BY_TYPE);
                request.setAttribute(activeDoctors, doctors);
                request.setAttribute(activePatients, patients);
                session.setAttribute(isSorted,"true");
                break;
            case 3:
                patients.sort(SORT_PATIENTS_BY_ALPHABET);
                request.setAttribute(activeDoctors, doctors);
                request.setAttribute(activePatients, patients);
                session.setAttribute(isSorted,"true");
                break;
            case 4:
                patients.sort(SORT_PATIENTS_BY_DATE);
                request.setAttribute(activeDoctors, doctors);
                request.setAttribute(activePatients, patients);
                session.setAttribute(isSorted,"true");
                break;
            default:
                break;
        }
        request.getRequestDispatcher(ADMIN_HOME).forward(request, response);
    }
}
