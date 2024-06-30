package com.example.bzurs;

public class Course {
    private String course_ID;
    private String courses_Name;
    private int credit_Hours;
    private int department_ID;

    public Course(String course_ID, String courses_Name, int credit_Hours, int department_ID) {
        this.course_ID = course_ID;
        this.courses_Name = courses_Name;
        this.credit_Hours = credit_Hours;
        this.department_ID = department_ID;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourses_Name() {
        return courses_Name;
    }

    public void setCourses_Name(String courses_Name) {
        this.courses_Name = courses_Name;
    }

    public int getCredit_Hours() {
        return credit_Hours;
    }

    public void setCredit_Hours(int credit_Hours) {
        this.credit_Hours = credit_Hours;
    }


    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }

    @Override
    public String toString() {
        return "Course ID: " + course_ID +
                ", Courses Name: " + courses_Name +
                ", Credit Hours: " + credit_Hours +
                ", Department ID: " + department_ID;
    }
}
