package service.impl;

import model.dao.interfaces.PatientDAOImpl;
import model.entity.Patient;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

public class PatientService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final PatientDAOImpl patientDAO = daoFactory.createPatientDAO();

    public PatientService() {
    }

    public List<Patient> findAll() {
        return patientDAO.findAllPatients();
    }
    public List<Patient> findAllDoctorPatients(int doctorId) {
        return patientDAO.findAllDoctorPatients(doctorId);
    }

    public void assignDoctor(int doctorId, int patientId) {
        patientDAO.assignDoctorToPatient(doctorId, patientId);
    }

    public void assignNurse(int nurseId, int patientId) {
        patientDAO.assignNurseToPatient(nurseId, patientId);
    }

    public void assignTreatment(int treatmentId, int patientId) {
        patientDAO.assignTreatmentToPatient(treatmentId, patientId);
    }
    public boolean registerPatient(int id, int patientId) {
        return patientDAO.insertPatient(id, patientId);
    }

    public Patient findPatientById(int id) {
        return patientDAO.findPatientById(id);
    }
}
