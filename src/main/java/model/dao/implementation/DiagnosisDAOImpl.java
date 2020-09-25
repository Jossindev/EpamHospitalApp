package model.dao.implementation;

import model.dao.interfaces.DiagnosisDAO;
import model.entity.Diagnosis;
import utils.PoolConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DiagnosisDAOImpl implements DiagnosisDAO {
    private static Logger logger = Logger.getLogger(DiagnosisDAOImpl.class);

    public DiagnosisDAOImpl() {
    }

    public List<Diagnosis> findAll() {
        List<Diagnosis> result = new ArrayList<>();
        String sql = "select * from diagnosis";
        try (Connection connection = PoolConnections.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("description");
                String difficulty = resultSet.getString("difficulty");
                Diagnosis diagnosis = new Diagnosis(id, name, difficulty);

                result.add(diagnosis);
            }
        } catch (Exception e) {
            logger.error("Can not find all diagnoses ", e);
        }
        return result;
    }

    public Diagnosis findById(int id) {
        Diagnosis diagnosis = null;
        String sql = "select * from diagnosis where id =?";
        try (Connection connection = PoolConnections.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    diagnosis = new Diagnosis(resultSet.getInt("id"),
                            resultSet.getString("description"),
                            resultSet.getString("difficulty"));
                }
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }
        return diagnosis;
    }

}
