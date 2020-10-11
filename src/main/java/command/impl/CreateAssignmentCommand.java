package command.impl;

import command.HospitalCommand;
import service.impl.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPaths.DOCTOR_HOME;

public class CreateAssignmentCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reporterId = Integer.parseInt(request.getParameter("userId2"));
        int id = Integer.parseInt(request.getParameter("patientId2"));
        String description = request.getParameter("description");

        AssignmentService service = new AssignmentService();
        service.updateAssignmentReporter(reporterId, id, description);

        request.getRequestDispatcher(DOCTOR_HOME).forward(request, response);
    }
}
