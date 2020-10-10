package model.dao;

import model.entity.Doctor;
import model.entity.Patient;
import org.apache.log4j.Logger;
import model.database.PoolConnections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements model.dao.interfaces.PatientDAOImpl {
    private static final String FIND_ALL_DOCTOR_PATIENTS = "select * from patient where doctor_id = ?";
    private static final String FIND_ALL_PATIENTS = "select * from patient";
    private static final String ASSIGN_DOCTOR = "update patient set doctor_id = ? where id = ?";
    private static final String ASSIGN_NURSE = "update patient set nurse_id = ? where id = ?";
    private static final String ASSIGN_TREATMENT = "update patient set treatment_id = ? where id = ?";
    private static final String INSERT_PATIENT = "insert into patient(id, user_id) values(?,?)";
    private static final Logger logger = Logger.getLogger(PatientDAOImpl.class);

    public PatientDAOImpl() {
    }

    @Override
    public List<Patient> findAllPatients() {
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PATIENTS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user = resultSet.getInt("user_id");
                int doctor = resultSet.getInt("doctor_id");
                int nurse = resultSet.getInt("nurse_id");
                int treatment = resultSet.getInt("treatment_id");

                Patient patient = new Patient(id, user, doctor, nurse, treatment);
                patients.add(patient);
            }
        } catch (SQLException e) {
            logger.error("Can not find all users ", e);
        }
        return patients;
    }

    @Override
    public List<Patient> findAllDoctorPatients(int doctorId) {
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DOCTOR_PATIENTS)) {
            statement.setInt(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int user = resultSet.getInt("user_id");
                    int doctor = resultSet.getInt("doctor_id");
                    int nurse = resultSet.getInt("nurse_id");
                    int treatment = resultSet.getInt("treatment_id");

                    Patient patient = new Patient(id, user, doctor, nurse, treatment);
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find all doctor patients", e);
        }
        return patients;
    }

    @Override
    public void assignDoctorToPatient(int doctorId, int patientId) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(ASSIGN_DOCTOR)) {
            statement.setInt(1, doctorId);
            statement.setInt(2, patientId);
            statement.executeQuery();

        } catch (SQLException e) {
            logger.error("Can not assign doctor to patient", e);
        }
    }

    @Override
    public void assignNurseToPatient(int nurseId, int patientId) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(ASSIGN_NURSE)) {
            statement.setInt(1, nurseId);
            statement.setInt(2, patientId);
            statement.executeQuery();

        } catch (SQLException e) {
            logger.error("Can not assign nurse to patient", e);
        }
    }

    @Override
    public void assignTreatmentToPatient(int treatmentId, int patientId) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(ASSIGN_TREATMENT)) {
            statement.setInt(1, treatmentId);
            statement.setInt(2, patientId);
            statement.executeQuery();

        } catch (SQLException e) {
            logger.error("Can not assign treatment to patient", e);
        }
    }

    @Override
    public boolean insertPatient(int id, int patientId) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PATIENT)) {
            statement.setInt(1, id);
            statement.setInt(2, patientId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.error("Can not insert doctor", e);
            return false;
        }
    }
}
