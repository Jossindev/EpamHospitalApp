package command.impl;

import command.HospitalCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPages.HOME_HOSPITAL;

public class HomeCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(HOME_HOSPITAL).forward(request, response);
    }
}
