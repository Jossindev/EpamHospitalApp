package model.entity;

import java.util.Objects;

public class Doctor {
    private int id;
    private User user;
    private String doctorType;

    public Doctor(int id, User userId, String doctorType) {
        this.id = id;
        this.user = userId;
        this.doctorType = doctorType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user= userId;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                Objects.equals(user, doctor.user) &&
                Objects.equals(doctorType, doctor.doctorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, doctorType);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", userId=" + user +
                ", doctorType='" + doctorType + '\'' +
                '}';
    }
}
