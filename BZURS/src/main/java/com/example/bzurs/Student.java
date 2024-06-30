package com.example.bzurs;

import java.util.Calendar;

public class Student {
    private int Student_ID;
    private String student_Name;
    private int National_ID;

    private Calendar BirthDate;
    private char gender;
    private String phone_Number;
    private String address;
    private String graduation_Status;
    private double balance;
    private String email;
    private int community_Hours;
    private int major_id;
    private double GPA;

    private int age;

    public Student(int student_ID, String student_Name,
                   int national_ID, String birthDate, char gender,
                   String phone_Number, String address,
                   String graduation_Status, double balance,
                   String email, int community_Hours, int major_id,
                   double GPA) {
        Student_ID = student_ID;
        this.student_Name = student_Name;
        National_ID = national_ID;
        String[] token = birthDate.split("-");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(token[0]), Integer.valueOf(token[1]) - 1,
                Integer.parseInt(token[2]));
        this.BirthDate = c;
        this.gender = gender;
        this.phone_Number = phone_Number;
        this.address = address;
        this.graduation_Status = graduation_Status;
        this.balance = balance;
        this.email = email;
        this.community_Hours = community_Hours;
        this.major_id = major_id;
        this.GPA = GPA;
        int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(token[0]);
        if(Calendar.getInstance().get(Calendar.MONTH) < Integer.valueOf(token[1]) ){
            age -= 1;
        } else if (Calendar.getInstance().get(Calendar.MONTH) == Integer.valueOf(token[1]) )
            if(Calendar.getInstance().get(Calendar.DATE) < Integer.valueOf(token[2]))
                age -= 1;
        this.age = age;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public int getNational_ID() {
        return National_ID;
    }

    public String getBirthDate() {
        if(this.BirthDate != null)
            return  BirthDate.get(Calendar.YEAR)+ "-"
                    + (BirthDate.get(Calendar.MONTH) + 1) + "-"
                    + BirthDate.get(Calendar.DATE);
        else
            return "Birth date is not entered";
    }

    public void setBirthDate(String birthDate) {
        String[] token = birthDate.split("-");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(token[0]), Integer.valueOf(token[1]) - 1,
                Integer.parseInt(token[2]));
        this.BirthDate = c;
    }
    public char getGender() {
        return gender;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGraduation_Status() {
        return graduation_Status;
    }

    public void setGraduation_Status(String graduation_Status) {
        this.graduation_Status = graduation_Status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCommunity_Hours() {
        return community_Hours;
    }

    public void setCommunity_Hours(int community_Hours) {
        this.community_Hours = community_Hours;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Student ID: " + Student_ID + ", Name: " + student_Name
                + ", National ID: " + National_ID + ", Birth Date: "
                + getBirthDate() + ", Gender: " + gender + ", Phone number: "
                + phone_Number + ", Address: " + address + ", Graduation Status:"
                + graduation_Status + ", Balance: " + balance + "JOD, Email: "
                + email + ", Community hours done: " + community_Hours;
    }

}

