package command.impl;

import command.HospitalCommand;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPages.*;


/**
 * The type Patient register.
 */
public class PatientRegister implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int patientId = Integer.parseInt(request.getParameter("patientId"));

        PatientService service = new PatientService();
        service.registerPatient(userId, patientId);

        request.getRequestDispatcher(REGISTER_PATIENT).forward(request, response);
    }
}
