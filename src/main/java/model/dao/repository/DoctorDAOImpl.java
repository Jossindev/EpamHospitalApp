package model.dao.repository;

import model.entity.Doctor;
import org.apache.log4j.Logger;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements model.dao.interfaces.DoctorDAO {
    private static Logger logger = Logger.getLogger(DoctorDAOImpl.class);

    private static final String INSERT_DOCTOR = "insert into doctor(id, user_id, doctor_type) values(?,?,?)";
    private static final String FIND_ALL_DOCTORS = "select * from doctor where doctor_type <>'Медсестра'";
    private static final String FIND_ALL_NURSES = "select * from doctor where doctor_type ='Медсестра'";
    private static final String FIND_DOCTOR_BY_ID = "select * from doctor where id = ?";

    public DoctorDAOImpl() {
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        return getDoctors(doctors, FIND_ALL_DOCTORS);
    }

    @Override
    public List<Doctor> findAllNurses() {
        List<Doctor> doctors = new ArrayList<>();
        return getDoctors(doctors, FIND_ALL_NURSES);
    }

    private List<Doctor> getDoctors(List<Doctor> doctors, String sql) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String type = resultSet.getString("doctor_type");

                Doctor doctor = new Doctor(id, userId, type);
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            logger.error("Can not find all doctors", e);
        }
        return doctors;
    }

    @Override
    public Doctor insertDoctor(Doctor doctor) {
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_DOCTOR)) {
            statement.setInt(1, doctor.getId());
            statement.setInt(2, doctor.getUserId().getId());
            statement.setString(3, doctor.getDoctorType());
            statement.execute();
        } catch (SQLException e) {
            logger.error("Can not insert doctor", e);
        }
        return doctor;
    }


    @Override
    public Doctor findDoctorById(int id) {
        Doctor doctor = null;

        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_DOCTOR_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    doctor = new Doctor(resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("doctor_type"));
                }
            }
        } catch (SQLException e) {
            logger.error("Can not find doctor by id", e);
        }
        return doctor;
    }

}
