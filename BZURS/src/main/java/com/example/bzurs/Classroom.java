package com.example.bzurs;

public class Classroom {
    private int classroom_ID;
    private int classroom_Capacity;
    private String classroom_name;

    public Classroom(int classroom_ID, int classroom_Capacity, String classroom_name) {
        this.classroom_ID = classroom_ID;
        this.classroom_Capacity = classroom_Capacity;
        this.classroom_name = classroom_name;
    }

    public int getClassroom_ID() {
        return classroom_ID;
    }

    public int getClassroom_Capacity() {
        return classroom_Capacity;
    }

    public void setClassroom_Capacity(int classroom_Capacity) {
        this.classroom_Capacity = classroom_Capacity;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    @Override
    public String toString() {
        return "Classroom ID: " + classroom_ID +
                ", Classroom Capacity: " + classroom_Capacity +
                ", Classroom Name: " + classroom_name;
    }
}
