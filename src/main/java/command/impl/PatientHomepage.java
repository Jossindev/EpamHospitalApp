package command.impl;

import command.HospitalCommand;
import model.entity.Patient;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constant.HospitalPages.PATIENT_HOME;

public class PatientHomepage implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String stringId = String.valueOf(session.getAttribute("user_id"));

        int id = Integer.parseInt(stringId);

        PatientService patientService = new PatientService();
        Patient patient = patientService.findPatientById(id);

        request.setAttribute("currentPatient", patient);

        request.getRequestDispatcher(PATIENT_HOME).forward(request, response);
    }
}
