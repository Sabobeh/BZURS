package com.example.bzurs;

public class StudyPlan {
    private String course_ID;
    private int program_ID;

    public StudyPlan(String course_ID, int program_ID) {
        this.course_ID = course_ID;
        this.program_ID = program_ID;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }

    public int getProgram_ID() {
        return program_ID;
    }

    public void setProgram_ID(int program_ID) {
        this.program_ID = program_ID;
    }

    @Override
    public String toString() {
        return  "Course ID: " + course_ID +
                ", Program ID: " + program_ID;
    }
}
