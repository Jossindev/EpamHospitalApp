package model.entity;

import model.dao.DoctorDAOImpl;
import model.dao.TreatmentDAOImpl;

import java.util.Objects;

public class Patient {
    private int id;
    private Doctor doctor;
    private Doctor nurse;
    private Treatment treatment;

    public Patient(int id) {
        this.id = id;
    }

    public Patient(int id, Doctor doctor, Doctor nurse, Treatment treatment) {
        this.id = id;
        this.doctor = doctor;
        this.nurse = nurse;
        this.treatment = treatment;
    }
    public Patient(int id, int doctor, int nurse, int treatment) {
        this.id = id;
        this.doctor = detectDoctor(doctor);
        this.nurse = detectDoctor(nurse);
        this.treatment = detectTreatment(treatment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getNurse() {
        return nurse;
    }

    public void setNurse(Doctor nurse) {
        this.nurse = nurse;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(doctor, patient.doctor) &&
                Objects.equals(nurse, patient.nurse) &&
                Objects.equals(treatment, patient.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, nurse, treatment);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                ", treatment=" + treatment +
                '}';
    }
    public Doctor detectDoctor(int id) {
        return new DoctorDAOImpl().findDoctorById(id);
    }
    public Treatment detectTreatment(int id) {
        return new TreatmentDAOImpl().findById(id);
    }
}
