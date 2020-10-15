package service.impl;

import model.dao.DoctorDAOImpl;
import model.entity.Doctor;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

/**
 * The type Doctor service.
 */
public class DoctorService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final DoctorDAOImpl doctorDAO = daoFactory.createDoctorDAO();

    /**
     * Instantiates a new Doctor service.
     */
    public DoctorService() { }

    /**
     * Add doctor doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    public Doctor addDoctor(Doctor doctor) {
        return doctorDAO.insertDoctor(doctor);
    }

    /**
     * Find doctor doctor.
     *
     * @param id the id
     * @return the doctor
     */
    public Doctor findDoctor(int id) {
        return doctorDAO.findDoctorById(id);
    }

    /**
     * Find all doctors list.
     *
     * @return the list
     */
    public List<Doctor> findAllDoctors() {
        return doctorDAO.findAllDoctors();
    }

    /**
     * Find all nurses list.
     *
     * @param id the id
     * @return the list
     */
    public List<Doctor> findAllNurses(int id) {
        return doctorDAO.findAllNurses();
    }
}
