package model.dao.interfaces;

import model.entity.Patient;

import java.util.List;

/**
 * The interface Patient dao.
 */
public interface PatientDAOImpl {
    /**
     * Find all doctor patients list.
     *
     * @param doctorId the doctor id
     * @return the list
     */
    List<Patient> findAllDoctorPatients(int doctorId);

    /**
     * Assign doctor to patient.
     *
     * @param doctorId  the doctor id
     * @param patientId the patient id
     */
    void assignDoctorToPatient(int doctorId, int patientId);

    /**
     * Assign nurse to patient.
     *
     * @param nurseId   the nurse id
     * @param patientId the patient id
     */
    void assignNurseToPatient(int nurseId, int patientId);

    /**
     * Assign treatment to patient.
     *
     * @param treatmentId the treatment id
     * @param patientId   the patient id
     */
    void assignTreatmentToPatient(int treatmentId, int patientId);

    /**
     * Find all patients list.
     *
     * @return the list
     */
    List<Patient> findAllPatients();

    /**
     * Insert patient boolean.
     *
     * @param id        the id
     * @param patientId the patient id
     * @return the boolean
     */
    public boolean insertPatient(int id, int patientId);

    /**
     * Find patient by id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient findPatientById(int id);
}
