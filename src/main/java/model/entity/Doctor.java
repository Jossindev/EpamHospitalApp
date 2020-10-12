package model.entity;

import model.dao.UserDAOImpl;

import java.util.Objects;
import java.util.Optional;

public class Doctor  {
    private int id;
    private User userId;
    private String doctorType;

    public Doctor(int id, int userId, String doctorType) {
        this.id = id;
        this.userId = detectUser(userId).get();
        this.doctorType = doctorType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
                Objects.equals(userId, doctor.userId) &&
                Objects.equals(doctorType, doctor.doctorType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, doctorType);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorType='" + doctorType + '\'' +
                '}';
    }
    public Optional<User> detectUser(int id) {
        return new UserDAOImpl().findById(id);
    }
}
