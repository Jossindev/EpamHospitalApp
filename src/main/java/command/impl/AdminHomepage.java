package command.impl;

import command.HospitalCommand;
import model.entity.Doctor;
import model.entity.Patient;
import service.impl.DoctorService;
import service.impl.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import static constant.HospitalPages.ADMIN_HOME;

public class AdminHomepage implements HospitalCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.findAll();
        request.setAttribute("activePatients", patients);

        DoctorService service = new DoctorService();
        List<Doctor> doctors = service.findAllDoctors();
        request.setAttribute("activeDoctors", doctors);

        request.getRequestDispatcher(ADMIN_HOME).forward(request, response);
    }
}
