package command.impl;

import command.HospitalCommand;
import constant.HospitalPages;
import constant.HospitalPaths;
import service.validation.AuthValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginCommand implements HospitalCommand {
    AuthValidation validation = new AuthValidation();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isSuccessful = validation.login(email, password, session);
        if (isSuccessful) {
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location", defineRole(session));
            return;
        }

        request.setAttribute("bad_getaway", true);
        request.getRequestDispatcher(HospitalPages.SIGN_IN).forward(request, response);
    }

    private String defineRole(HttpSession session) {
        String currentRole = (String) session.getAttribute("role");

        switch (currentRole) {
            case "ADMIN":
                return HospitalPaths.ADMIN_HOME;
            case "DOCTOR":
                return HospitalPaths.DOCTOR_HOME;
            case "PATIENT":
                return HospitalPaths.PATIENT_HOME;
            default: return "/";
        }
    }
}
