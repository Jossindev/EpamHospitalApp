package entity;

public class Prescription {
    private int id;
    private String name;
    private String prescriptionClass;
    private int amountOfMedicine;

    public Prescription (int id, String name, String prescriptionClass) {
        this.id = id;
        this.name = name;
        this.prescriptionClass = prescriptionClass;
    }

    public Prescription (String name, int amount) {
        this.name = name;
        this.amountOfMedicine = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrescriptionClass(String prescriptionClass) {
        this.prescriptionClass = prescriptionClass;
    }

    public void setAmountOfMedicine(int amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrescriptionClass() {
        return prescriptionClass;
    }

    public int getAmountOfMedicine() {
        return amountOfMedicine;
    }
}
