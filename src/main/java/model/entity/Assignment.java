package model.entity;

import model.dao.AssignmentTypeDAOImpl;
import model.dao.DoctorDAOImpl;

import java.util.Objects;

public class Assignment {
    private int id;
    private Doctor executor;
    private Doctor reporter;
    private String description;
    private AssignmentType type;

    public Assignment(int id) {
        this.id = id;
    }


    public Assignment(int id, int executor, int reporter, String description, int type) {
        this.id = id;
        this.executor = detectDoctor(executor);
        this.reporter = detectDoctor(reporter);
        this.description = description;
        this.type = detectAssignmentType(type);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getExecutor() {
        return executor;
    }

    public void setExecutor(Doctor executor) {
        this.executor = executor;
    }

    public Doctor getReporter() {
        return reporter;
    }

    public void setReporter(Doctor reporter) {
        this.reporter = reporter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssignmentType getType() {
        return type;
    }

    public void setType(AssignmentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return id == that.id &&
                Objects.equals(executor, that.executor) &&
                Objects.equals(reporter, that.reporter) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, executor, reporter, description, type);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", executor=" + executor +
                ", reporter=" + reporter +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }

    public Doctor detectDoctor(int id) {
        return new DoctorDAOImpl().findDoctorById(id);
    }

    public AssignmentType detectAssignmentType(int id) {
        return new AssignmentTypeDAOImpl().findById(id);
    }
}
