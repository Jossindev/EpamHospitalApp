package model.dao.implementation;

import model.dao.interfaces.TreatmentDao;
import model.entity.Treatment;
import org.apache.log4j.Logger;
import utils.PoolConnections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDAOImpl implements TreatmentDao {
    private static Logger logger = Logger.getLogger(TreatmentDAOImpl.class);

    public TreatmentDAOImpl() {
    }

    @Override
    public Treatment findPatientById(int id) {
        Treatment treatment = null;
        String sql = "select * from treatment where patient_id = ?";
        return getTreatment(id, sql);
    }

    @Override
    public Treatment findDoctorById(int id) {
        Treatment treatment = null;
        String sql = "select * from treatment where doctor_id = ?";
        return getTreatment(id, sql);
    }

    private Treatment getTreatment(int id, String sql) {
        Treatment treatment = null;
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                treatment = new Treatment(resultSet.getInt("patient_id"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("nurse_id"),
                        resultSet.getInt("diagnosis_id"));
            }
        } catch (SQLException e) {
            logger.error("Can not find patient or doctor by id", e);
        }
        return treatment;
    }

    @Override
    public List<Treatment> findDoctorPatients(int id) {
        List<Treatment> result = new ArrayList<>();
        String sql = "select * from treatment where doctor_id = ?";
        return getTreatments(id, result, sql);
    }

    @Override
    public List<Treatment> findNursePatients(int id) {
        List<Treatment> result = new ArrayList<>();
        String sql = "select * from treatment where nurse_id = ?";
        return getTreatments(id, result, sql);
    }

    private List<Treatment> getTreatments(int id, List<Treatment> result, String sql) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int patientId = resultSet.getInt("patient_id");
                    int doctorId = resultSet.getInt("doctor_id");
                    int nurseId = resultSet.getInt("nurse_id");
                    int diagnosisId = resultSet.getInt("diagnosis_id");
                    Treatment user = new Treatment(patientId, doctorId, nurseId, diagnosisId);
                    result.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find patients", e);
        }
        return result;
    }

    @Override
    public void insert(int id) {
        String sql = "insert into treatment(patient_id) values (?)";

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            logger.error("Can not insert patient", e);
        }
    }

    @Override
    public void updatePatientDoctor(int doctorId, int patientId) {
        String sql = "update treatment set doctor_id = ? where patient_id = ?";

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            statement.setInt(2, patientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update patient doctor ", e);
        }
    }

    @Override
    public void updatePatientNurse(int nurseId, int patientId) {
        String sql = "update treatment set nurse_id = ? where patient_id = ?";
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, nurseId);
            statement.setInt(2, patientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update patient nurse ", e);

        }
    }

    @Override
    public void updatePatientDiagnosis(int diagnosisId, int patientId) {
        String sql = "update treatment set diagnosis_id = ? where patient_id = ?";
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, diagnosisId);
            statement.setInt(2, patientId);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can not update patient diagnosis ", e);
        }
    }

    @Override
    public List<Treatment> findPatientsWhereNoDoctor() {
        List<Treatment> result = new ArrayList<>();
        String sql = "select * from treatment where doctor_id IS NULL";

        return getTreatments(result, sql);
    }

    @Override
    public List<Treatment> findPatientsWhereNoNurse() {
        List<Treatment> result = new ArrayList<>();
        String sql = "select * from treatment where nurse_id IS NULL";

        return getTreatments(result, sql);
    }

    private List<Treatment> getTreatments(List<Treatment> result, String sql) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int patientId = resultSet.getInt("patient_id");
                    int doctorId = resultSet.getInt("doctor_id");
                    int nurseId = resultSet.getInt("nurse_id");
                    int diagnosisId = resultSet.getInt("diagnosis_id");

                    Treatment treatment = new Treatment(patientId, doctorId, nurseId, diagnosisId);
                    result.add(treatment);
                }
            }
        } catch (Exception e) {
            logger.error("Can not find patient where no nurse or doctor ", e);
        }
        return result;
    }
}
