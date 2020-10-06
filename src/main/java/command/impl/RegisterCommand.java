package command.impl;

import command.HospitalCommand;
import constant.HospitalPages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(HospitalPages.SIGN_UP).forward(request, response);
    }
}
