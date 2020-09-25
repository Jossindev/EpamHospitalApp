package model.entity;

import model.dao.implementation.DiagnosisDAOImpl;
import model.dao.implementation.UserDAOImpl;

import java.util.Objects;

public class Treatment {
    private int id;
    private User patient;
    private User doctor;
    private User nurse;
    private String comment;
    private Assignment assignments;
    private Diagnosis diagnosis;

    public Treatment() { }

    public Treatment(int id) {
        this.id = id;
    }

    public Treatment(int patientId, int doctorId, int nurseId, int diagnosisId) {
        this.patient = detectPerson(patientId);
        this.doctor = detectPerson(doctorId);
        this.nurse = detectPerson(nurseId);
        this.diagnosis = detectDiagnosis(diagnosisId);
    }

    public int getId() { return id; }

    public User getPatient() {
        return patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public User getNurse() {
        return nurse;
    }

    public String getComment() {
        return comment;
    }

    public Assignment getAssignments() {
        return assignments;
    }

    public Diagnosis getDiagnoses() {
        return diagnosis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAssignments(Assignment assignments) {
        this.assignments = assignments;
    }

    public void setDiagnoses(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return id == treatment.id &&
                Objects.equals(patient, treatment.patient) &&
                Objects.equals(doctor, treatment.doctor) &&
                Objects.equals(nurse, treatment.nurse) &&
                Objects.equals(comment, treatment.comment) &&
                Objects.equals(assignments, treatment.assignments) &&
                Objects.equals(diagnosis, treatment.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, nurse, comment, assignments, diagnosis);
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                ", comment='" + comment + '\'' +
                ", assignments=" + assignments +
                ", diagnoses=" + diagnosis +
                '}';
    }

    public User detectPerson(int id) {
        return new UserDAOImpl().findById(id);
    }

    public Diagnosis detectDiagnosis(int id) {
        return new DiagnosisDAOImpl().findById(id);
    }
}
