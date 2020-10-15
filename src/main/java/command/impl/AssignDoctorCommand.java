package command.impl;

import command.HospitalCommand;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPaths.ADMIN_HOME;

/**
 * The type Assign doctor command.
 */
public class AssignDoctorCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        int docId = Integer.parseInt(request.getParameter("doctorId"));
        int nurseId = Integer.parseInt(request.getParameter("nurseId"));

        PatientService service = new PatientService();
        service.assignDoctor(docId, id);
        service.assignNurse(nurseId, id);

        request.getRequestDispatcher(ADMIN_HOME).forward(request, response);
    }
}
