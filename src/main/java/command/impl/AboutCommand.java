package command.impl;

import command.HospitalCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPages.ABOUT;


public class AboutCommand implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ABOUT).forward(request, response);
    }
}
