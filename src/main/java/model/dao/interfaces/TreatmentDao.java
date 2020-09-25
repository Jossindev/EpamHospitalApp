package model.dao.interfaces;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentDao {
    public Treatment findPatientById(int id);

    public Treatment findDoctorById(int id);

    public List<Treatment> findDoctorPatients(int id);

    public List<Treatment> findNursePatients(int id);

    public void insert(int id);

    public void updatePatientDoctor(int doctorId, int patientId);

    public void updatePatientNurse(int nurseId, int patientId);

    public void updatePatientDiagnosis(int diagnosisId, int patientId);

    public List<Treatment> findPatientsWhereNoDoctor();

    public List<Treatment> findPatientsWhereNoNurse();
}
