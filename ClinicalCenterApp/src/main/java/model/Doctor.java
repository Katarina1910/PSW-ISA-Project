package model;

public class Doctor extends Personnel {
    private double grade;

    public Doctor() {
    }

    public Doctor(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
