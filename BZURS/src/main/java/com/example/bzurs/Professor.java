package com.example.bzurs;

import java.util.Calendar;

public class Professor {
    private int professor_ID;
    private String professor_Name;
    private int national_ID;
    private Calendar professor_BirthDate;
    private char gender;
    private String professor_Phone_Number;
    private String professor_Address;
    private String professor_Degree;
    private String professor_Email;
    private int professor_Age;
    private int department_ID;

    public Professor(int professor_ID, String professor_Name, int national_ID,
                     String professor_BirthDate, char gender, String professor_Phone_Number
            , String professor_Address, String professor_Degree, String professor_Email,
                     int department_ID) {
        this.professor_ID = professor_ID;
        this.professor_Name = professor_Name;
        this.national_ID = national_ID;
        String[] token = professor_BirthDate.split("-");
        if(token.length == 3) {
            Calendar c = Calendar.getInstance();
            c.set(Integer.parseInt(token[0]), Integer.valueOf(token[1]) - 1,
                    Integer.parseInt(token[2]));
            this.professor_BirthDate = c;
        } else
            this.professor_BirthDate = null;
        this.gender = gender;
        this.professor_Phone_Number = professor_Phone_Number;
        this.professor_Address = professor_Address;
        this.professor_Degree = professor_Degree;
        this.professor_Email = professor_Email;
        if(this.professor_BirthDate != null) {
            int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(token[0]);
            if (Calendar.getInstance().get(Calendar.MONTH) < Integer.valueOf(token[1])) {
                age -= 1;
            } else if (Calendar.getInstance().get(Calendar.MONTH) == Integer.valueOf(token[1]))
                if (Calendar.getInstance().get(Calendar.DATE) < Integer.valueOf(token[2]))
                    age -= 1;
            this.professor_Age = age;
        } else
            this.professor_Age = 0;
        this.department_ID = department_ID;
    }

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
    }

    public String getProfessor_Name() {
        return professor_Name;
    }

    public void setProfessor_Name(String professor_Name) {
        this.professor_Name = professor_Name;
    }

    public int getNational_ID() {
        return national_ID;
    }

    public void setNational_ID(int national_ID) {
        this.national_ID = national_ID;
    }

    public String getProfessor_BirthDate() {
        if(this.professor_BirthDate != null)
            return  professor_BirthDate.get(Calendar.YEAR)+ "-"
                    + (professor_BirthDate.get(Calendar.MONTH) + 1) + "-"
                    + professor_BirthDate.get(Calendar.DATE);
        else
            return "Birth date is not entered";
    }

    public void setProfessor_BirthDate(String professor_BirthDate) {
        String[] token = professor_BirthDate.split("-");

        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(token[0]), Integer.valueOf(token[1]) - 1,
                Integer.parseInt(token[2]));
        this.professor_BirthDate = c;
        if (this.professor_BirthDate != null) {
            int age1 = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(token[0]);
            if (Calendar.getInstance().get(Calendar.MONTH) < Integer.valueOf(token[1])) {
                age1 -= 1;
            } else if (Calendar.getInstance().get(Calendar.MONTH) == Integer.valueOf(token[1]))
                if (Calendar.getInstance().get(Calendar.DATE) < Integer.valueOf(token[2]))
                    age1 -= 1;
            this.professor_Age = age1;
        }
    }

    public String getGender() {
        return gender+"";
    }

    public void setGender(String gender) {
        this.gender = gender.charAt(0);
    }

    public String getProfessor_Phone_Number() {
        return professor_Phone_Number;
    }

    public void setProfessor_Phone_Number(String professor_Phone_Number) {
        this.professor_Phone_Number = professor_Phone_Number;
    }

    public String getProfessor_Address() {
        return professor_Address;
    }

    public void setProfessor_Address(String professor_Address) {
        this.professor_Address = professor_Address;
    }

    public String getProfessor_Degree() {
        return professor_Degree;
    }

    public void setProfessor_Degree(String professor_Degree) {
        this.professor_Degree = professor_Degree;
    }

    public String getProfessor_Email() {
        return professor_Email;
    }

    public void setProfessor_Email(String professor_Email) {
        this.professor_Email = professor_Email;
    }

    public int getProfessor_Age() {
        return professor_Age;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }

    @Override
    public String toString() {
        return"Professor ID: " + professor_ID +
                ", Professor Name: " + professor_Name +
                ", National ID: " + national_ID +
                ", Professor BirthDate: " + getProfessor_BirthDate() +
                ", Gender: " + gender +
                ", Professor Phone Number: " + professor_Phone_Number +
                ", Professor Address: " + professor_Address +
                ", Professor Degree: " + professor_Degree +
                ", Professor Email: " + professor_Email +
                ", Professor Age: " + professor_Age +
                ", Department ID: " + department_ID;
    }
}
