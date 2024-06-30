package com.example.bzurs;

public class SenrollsS {
    private int student_ID;
    private int section_ID;
    private int absences;
    private double grade;

    public SenrollsS(int student_ID, int section_ID, int absences, double grade) {
        this.student_ID = student_ID;
        this.section_ID = section_ID;
        this.absences = absences;
        this.grade = grade;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public int getSection_ID() {
        return section_ID;
    }

    public void setSection_ID(int section_ID) {
        this.section_ID = section_ID;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return  "Student ID: " + student_ID +
                ", Section ID: " + section_ID +
                ", Absences: " + absences +
                ", Grade: " + grade;
    }
}
