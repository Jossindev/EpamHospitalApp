package command.impl;

import command.HospitalCommand;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPaths.DOCTOR_DEFINE_DIAGNOSIS;

public class DefineDiagnosisCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user"));
        int treatmentId = Integer.parseInt(request.getParameter("treatment"));

        PatientService service = new PatientService();
        service.assignTreatment(treatmentId, userId);

        request.getRequestDispatcher(DOCTOR_DEFINE_DIAGNOSIS).forward(request, response);
    }
}
