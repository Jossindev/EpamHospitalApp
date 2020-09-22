package entity;

import java.util.Objects;

public class Assignment {
    private int id;
    private String type;
    private User patient;
    private User doctor;
    private User nurse;
    private User executor;
    private Treatment treatment;

    public Assignment() {}
    public Assignment(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public User getExecutor() {
        return executor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(nurse, that.nurse) &&
                Objects.equals(executor, that.executor) &&
                Objects.equals(treatment, that.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, patient, doctor, nurse, executor, treatment);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                ", executor=" + executor +
                ", treatment=" + treatment +
                '}';
    }
}
