package com.example.bzurs;

public class SdoMinor {
    private int student_ID;
    private int minor_ID;

    public SdoMinor(int student_ID, int minor_ID) {
        this.student_ID = student_ID;
        this.minor_ID = minor_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public int getMinor_ID() {
        return minor_ID;
    }

    public void setMinor_ID(int minor_ID) {
        this.minor_ID = minor_ID;
    }

    @Override
    public String toString() {
        return  "Student ID: " + student_ID +
                ", Minor ID: " + minor_ID ;
    }
}
