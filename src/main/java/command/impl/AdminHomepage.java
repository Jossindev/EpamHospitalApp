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

import java.util.List;
import static constant.HospitalPages.ADMIN_HOME;

/**
 * The type Admin homepage.
 */
public class AdminHomepage implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String bool = String.valueOf(session.getAttribute("isSorted"));

        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.findAll();

        DoctorService service = new DoctorService();
        List<Doctor> doctors = service.findAllDoctors();

        if (bool.equals("false")) {
            request.setAttribute("activeDoctors", doctors);
            request.setAttribute("activePatients", patients);
        }
        request.getRequestDispatcher(ADMIN_HOME).forward(request, response);
    }
}
