package com.example.bzurs;

public class Pre_Course {
    private String course_ID;
    private String pre_course_ID;

    public Pre_Course(String course_ID, String pre_course_ID) {
        this.course_ID = course_ID;
        this.pre_course_ID = pre_course_ID;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }

    public String getPre_course_ID() {
        return pre_course_ID;
    }

    public void setPre_course_ID(String pre_course_ID) {
        this.pre_course_ID = pre_course_ID;
    }

    @Override
    public String toString() {
        return  "course ID: " + course_ID +
                ", Pre course ID: " + pre_course_ID;
    }
}
