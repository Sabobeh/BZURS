package com.example.bzurs;

public class Faculty {
    private int faculty_ID;
    private String faculty_Phone_Number;
    private String faculty_Name;
    private String faculty_Fax;
    private String faculty_Email;
    private int faculty_Manager_ID;

    public Faculty(int faculty_ID, String faculty_Phone_Number, String faculty_Name,
                   String faculty_Fax, String faculty_Email, int faculty_Manager_ID) {
        this.faculty_ID = faculty_ID;
        this.faculty_Phone_Number = faculty_Phone_Number;
        this.faculty_Name = faculty_Name;
        this.faculty_Fax = faculty_Fax;
        this.faculty_Email = faculty_Email;
        this.faculty_Manager_ID = faculty_Manager_ID;
    }

    public int getFaculty_ID() {
        return faculty_ID;
    }

    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
    }

    public String getFaculty_Phone_Number() {
        return faculty_Phone_Number;
    }

    public void setFaculty_Phone_Number(String faculty_Phone_Number) {
        this.faculty_Phone_Number = faculty_Phone_Number;
    }

    public String getFaculty_Name() {
        return faculty_Name;
    }

    public void setFaculty_Name(String faculty_Name) {
        this.faculty_Name = faculty_Name;
    }

    public String getFaculty_Fax() {
        return faculty_Fax;
    }

    public void setFaculty_Fax(String faculty_Fax) {
        this.faculty_Fax = faculty_Fax;
    }

    public String getFaculty_Email() {
        return faculty_Email;
    }

    public void setFaculty_Email(String faculty_Email) {
        this.faculty_Email = faculty_Email;
    }

    public int getFaculty_Manager_ID() {
        return faculty_Manager_ID;
    }

    public void setFaculty_Manager_ID(int faculty_Manager_ID) {
        this.faculty_Manager_ID = faculty_Manager_ID;
    }

    @Override
    public String toString() {
        return "Faculty ID: " + faculty_ID +
                ", Faculty Phone Number: " + faculty_Phone_Number +
                ", Faculty Name: " + faculty_Name +
                ", Faculty Fax: " + faculty_Fax +
                ", Faculty Email: " + faculty_Email +
                ", Faculty Manager ID: " + faculty_Manager_ID;
    }
}
