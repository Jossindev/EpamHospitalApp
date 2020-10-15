package command.impl;

import command.HospitalCommand;
import model.entity.Doctor;
import service.impl.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.HospitalPages.REGISTER_DOCTOR;

/**
 * The type Doctor register.
 */
public class DoctorRegister implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String doctorType = request.getParameter("doctorType");

        Doctor doctor = new Doctor(doctorId, userId, doctorType);
        DoctorService service = new DoctorService();
        service.addDoctor(doctor);

        request.getRequestDispatcher(REGISTER_DOCTOR).forward(request, response);
    }
}
