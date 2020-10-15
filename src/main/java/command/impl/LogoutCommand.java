package command.impl;

import command.HospitalCommand;
import constant.HospitalPages;
import service.validation.AuthValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The type Logout command.
 */
public class LogoutCommand implements HospitalCommand {
    /**
     * The Validation.
     */
    AuthValidation validation = new AuthValidation();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        validation.logout(session);
        request.getRequestDispatcher(HospitalPages.HOME_HOSPITAL).forward(request, response);
    }
}
