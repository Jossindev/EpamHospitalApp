package command.impl;

import command.HospitalCommand;
import service.impl.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPaths.DOCTOR_HOME;

/**
 * The type Complete assignment command.
 */
public class CompleteAssignmentCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId1"));
        int docId = Integer.parseInt(request.getParameter("patientId1"));

        AssignmentService service = new AssignmentService();
        service.updateAssignmentExecutor(docId, userId);

        request.getRequestDispatcher(DOCTOR_HOME).forward(request, response);
    }
}
