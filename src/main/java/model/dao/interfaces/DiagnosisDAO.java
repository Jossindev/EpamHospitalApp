package model.dao.interfaces;

import model.entity.Diagnosis;

import java.util.List;

public interface DiagnosisDAO {
    public List<Diagnosis> findAll();

    public Diagnosis findById(int id);
}
