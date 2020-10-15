package model.dao.interfaces;

import model.entity.Doctor;

import java.util.List;

/**
 * The interface Doctor dao.
 */
public interface DoctorDAO {
    /**
     * Find all doctors list.
     *
     * @return the list
     */
    List<Doctor> findAllDoctors();

    /**
     * Find all nurses list.
     *
     * @return the list
     */
    List<Doctor> findAllNurses();

    /**
     * Insert doctor doctor.
     *
     * @param doctor the doctor
     * @return the doctor
     */
    Doctor insertDoctor(Doctor doctor);

    /**
     * Find doctor by id doctor.
     *
     * @param id the id
     * @return the doctor
     */
    Doctor findDoctorById(int id);
}
