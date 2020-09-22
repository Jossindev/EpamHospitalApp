package model.entity;

import java.util.List;
import java.util.Objects;

public class Treatment {
    private int id;
    private User patient;
    private User doctor;
    private User nurse;
    private String comment;
    private List<Assignment> assignments;
    private List<Diagnosis> diagnoses;
    private boolean onTreatment;

    public Treatment() {}
    public Treatment(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public boolean isOnTreatment() {
        return onTreatment;
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

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setOnTreatment(boolean onTreatment) {
        this.onTreatment = onTreatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment treatment = (Treatment) o;
        return id == treatment.id &&
                onTreatment == treatment.onTreatment &&
                Objects.equals(patient, treatment.patient) &&
                Objects.equals(doctor, treatment.doctor) &&
                Objects.equals(nurse, treatment.nurse) &&
                Objects.equals(comment, treatment.comment) &&
                Objects.equals(assignments, treatment.assignments) &&
                Objects.equals(diagnoses, treatment.diagnoses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, nurse, comment, assignments, diagnoses, onTreatment);
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
                ", diagnoses=" + diagnoses +
                ", onTreatment=" + onTreatment +
                '}';
    }
}
