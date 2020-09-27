package model.dao.interfaces;

import model.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    List<Doctor> findAllDoctors();

    List<Doctor> findAllNurses();

    Doctor insertDoctor(Doctor doctor);

    Doctor findDoctorById(int id);
}
