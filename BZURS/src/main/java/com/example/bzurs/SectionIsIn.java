package com.example.bzurs;

public class SectionIsIn {
    private int classroom_ID;
    private int section_ID;
    private int timePeriod_ID;

    public SectionIsIn(int classroom_ID, int section_ID, int timePeriod_ID) {
        this.classroom_ID = classroom_ID;
        this.section_ID = section_ID;
        this.timePeriod_ID = timePeriod_ID;
    }

    public int getTimePeriod_ID() {
        return timePeriod_ID;
    }

    public void setTimePeriod_ID(int timePeriod_ID) {
        this.timePeriod_ID = timePeriod_ID;
    }

    public int getClassroom_ID() {
        return classroom_ID;
    }

    public void setClassroom_ID(int classroom_ID) {
        this.classroom_ID = classroom_ID;
    }

    public int getSection_ID() {
        return section_ID;
    }

    public void setSection_ID(int section_ID) {
        this.section_ID = section_ID;
    }

    @Override
    public String toString() {
        return  "Classroom ID: " + classroom_ID +
                ", Section ID: " + section_ID;
    }
}
