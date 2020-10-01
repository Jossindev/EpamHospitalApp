package service;

import model.dao.DoctorDAOImpl;
import model.entity.Doctor;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;


import java.util.List;

public class DoctorService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final DoctorDAOImpl doctorDAO = daoFactory.createDoctorDAO();

    public DoctorService() {
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorDAO.insertDoctor(doctor);
    }

    public Doctor findDoctor(int id) {
        return doctorDAO.findDoctorById(id);
    }

    public List<Doctor> findAllDoctors(int id) {
        return doctorDAO.findAllDoctors();
    }

    public List<Doctor> findAllNurses(int id) {
        return doctorDAO.findAllNurses();
    }

}
