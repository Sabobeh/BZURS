package com.example.bzurs;

public class Department {
    private int department_ID;
    private String department_Name;
    private String phone_Number;
    private String department_Email;
    private String department_Fax;
    private int faculty_ID;
    private int department_Manager_ID;

    public Department(int department_ID, String department_Name, String phone_Number,
                      String department_Email, String department_Fax, int faculty_ID,
                      int department_Manager_ID) {
        this.department_ID = department_ID;
        this.department_Name = department_Name;
        this.phone_Number = phone_Number;
        this.department_Email = department_Email;
        this.department_Fax = department_Fax;
        this.faculty_ID = faculty_ID;
        this.department_Manager_ID = department_Manager_ID;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }

    public String getDepartment_Name() {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        this.department_Name = department_Name;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getDepartment_Email() {
        return department_Email;
    }

    public void setDepartment_Email(String department_Email) {
        this.department_Email = department_Email;
    }

    public String getDepartment_Fax() {
        return department_Fax;
    }

    public void setDepartment_Fax(String department_Fax) {
        this.department_Fax = department_Fax;
    }

    public int getFaculty_ID() {
        return faculty_ID;
    }

    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
    }

    public int getDepartment_Manager_ID() {
        return department_Manager_ID;
    }

    public void setDepartment_Manager_ID(int department_Manager_ID) {
        this.department_Manager_ID = department_Manager_ID;
    }

    @Override
    public String toString() {
        return "Department ID: " + department_ID +
                ", Department Name: " + department_Name +
                ", Phone Number: " + phone_Number +
                ", Department Email: " + department_Email +
                ", Department Fax: " + department_Fax +
                ", Faculty ID: " + faculty_ID +
                ", Department Manager ID: " + department_Manager_ID;
    }
}
