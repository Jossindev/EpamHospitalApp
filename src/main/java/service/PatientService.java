package service;

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

    public List<Patient> findAllPatients(int doctorId) {
        return patientDAO.findAllDoctorPatients(doctorId);
    }

    public void assignDoctor(int patientId, int doctorId) {
        patientDAO.assignDoctorToPatient(patientId, doctorId);
    }

    public void assignNurse(int patientId, int nurseId) {
        patientDAO.assignDoctorToPatient(patientId, nurseId);
    }

    public void assignTreatment(int patientId, int treatmentId) {
        patientDAO.assignDoctorToPatient(patientId, treatmentId);
    }
}
