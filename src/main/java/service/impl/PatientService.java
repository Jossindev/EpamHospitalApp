package service.impl;

import model.dao.interfaces.PatientDAOImpl;
import model.entity.Patient;
import utils.factory.DaoFactory;
import utils.factory.DaoFactoryImpl;

import java.util.List;

/**
 * The type Patient service.
 */
public class PatientService {
    private static final DaoFactory daoFactory = DaoFactoryImpl.getInstance();
    private static final PatientDAOImpl patientDAO = daoFactory.createPatientDAO();

    /**
     * Instantiates a new Patient service.
     */
    public PatientService() {
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Patient> findAll() {
        return patientDAO.findAllPatients();
    }

    /**
     * Find all doctor patients list.
     *
     * @param doctorId the doctor id
     * @return the list
     */
    public List<Patient> findAllDoctorPatients(int doctorId) {
        return patientDAO.findAllDoctorPatients(doctorId);
    }

    /**
     * Assign doctor.
     *
     * @param doctorId  the doctor id
     * @param patientId the patient id
     */
    public void assignDoctor(int doctorId, int patientId) {
        patientDAO.assignDoctorToPatient(doctorId, patientId);
    }

    /**
     * Assign nurse.
     *
     * @param nurseId   the nurse id
     * @param patientId the patient id
     */
    public void assignNurse(int nurseId, int patientId) {
        patientDAO.assignNurseToPatient(nurseId, patientId);
    }

    /**
     * Assign treatment.
     *
     * @param treatmentId the treatment id
     * @param patientId   the patient id
     */
    public void assignTreatment(int treatmentId, int patientId) {
        patientDAO.assignTreatmentToPatient(treatmentId, patientId);
    }

    /**
     * Register patient boolean.
     *
     * @param id        the id
     * @param patientId the patient id
     * @return the boolean
     */
    public boolean registerPatient(int id, int patientId) {
        return patientDAO.insertPatient(id, patientId);
    }

    /**
     * Find patient by id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient findPatientById(int id) {
        return patientDAO.findPatientById(id);
    }
}
