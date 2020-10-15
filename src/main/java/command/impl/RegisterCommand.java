package command.impl;

import command.HospitalCommand;
import constant.HospitalPages;
import model.entity.User;
import service.validation.AuthValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * The type Register command.
 */
public class RegisterCommand implements HospitalCommand {
    private final AuthValidation validation = new AuthValidation();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        Date birthday = Date.valueOf((request.getParameter("birthday")));
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        int role = Integer.parseInt(request.getParameter("role"));

        User regUser = new User(name, surname, birthday, email, password, role);
        boolean isRegister = validation.register(regUser, confirmPassword);

        if (isRegister) {
            request.getRequestDispatcher(HospitalPages.SIGN_IN).forward(request, response);
            return;
        }

        request.setAttribute("bad_getaway", true);
        request.getRequestDispatcher(HospitalPages.SIGN_UP).forward(request, response);
    }
}
