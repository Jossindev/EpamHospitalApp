package model.dao.interfaces;

import model.entity.Patient;

import java.util.List;

public interface PatientDAOImpl {
    List<Patient> findAllDoctorPatients(int doctorId);

    void assignDoctorToPatient(int doctorId, int patientId);

    void assignNurseToPatient(int nurseId, int patientId);

    void assignTreatmentToPatient(int treatmentId, int patientId);

    List<Patient> findAllPatients();

    public boolean insertPatient(int id, int patientId);
}
