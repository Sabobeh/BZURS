package com.example.bzurs;

public class Section {
    private int section_ID;
    private int section_Year;
    private int section_Semester;
    private int professor_ID;
    private String course_ID;


    public Section(int section_ID, int section_Year, int section_Semester, int professor_ID,
                   String course_ID) {
        this.section_ID = section_ID;
        this.section_Year = section_Year;
        this.section_Semester = section_Semester;
        this.professor_ID = professor_ID;
        this.course_ID = course_ID;
    }


    public int getSection_ID() {
        return section_ID;
    }

    public void setSection_ID(int section_ID) {
        this.section_ID = section_ID;
    }

    public int getSection_Year() {
        return section_Year;
    }

    public void setSection_Year(int section_Year) {
        this.section_Year = section_Year;
    }

    public int getSection_Semester() {
        return section_Semester;
    }

    public void setSection_Semester(int section_Semester) {
        this.section_Semester = section_Semester;
    }

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }

    @Override
    public String toString() {
        return  "Section ID: " + section_ID +
                ", Section Year: " + section_Year +
                ", Section Semester: " + section_Semester +
                ", Professor ID: " + professor_ID +
                ", Course ID: " + course_ID;
    }
}
