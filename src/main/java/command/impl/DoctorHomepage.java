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


import static constant.HospitalPages.DOCTOR_HOME;

public class DoctorHomepage implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String stringId = String.valueOf(session.getAttribute("user_id"));

        int id = Integer.parseInt(stringId);

        DoctorService doctorService = new DoctorService();
        Doctor doctor = doctorService.findDoctor(id);

        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.findAllDoctorPatients(id);

        request.setAttribute("currentDoctor", doctor);
        request.setAttribute("patients", patients);

        request.getRequestDispatcher(DOCTOR_HOME).forward(request, response);
    }

}
