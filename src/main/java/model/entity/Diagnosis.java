package model.entity;

import java.util.Objects;

public class Diagnosis {
    private int id;
    private String description;
    private String difficulty;

    public Diagnosis() {}

    public Diagnosis(int id) {
        this.id = id;
    }

    public Diagnosis(int id, String description, String difficulty) {
        this.id = id;
        this.description = description;
        this.difficulty = difficulty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id == diagnosis.id &&
                Objects.equals(description, diagnosis.description) &&
                Objects.equals(difficulty, diagnosis.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, difficulty);
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
