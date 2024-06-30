package com.example.bzurs;

public class Program {
    private int program_ID;
    private String program_Name;
    private int credit_Hour_Price;
    private String abbreviation;
    private int credit_Hours;
    private String major_Minor;
    private int program_Department_ID;

    public Program(int program_ID, String program_Name, int credit_Hour_Price, String abbreviation,
                   int credit_Hours, String major_Minor, int program_Department_ID) {
        this.program_ID = program_ID;
        this.program_Name = program_Name;
        this.credit_Hour_Price = credit_Hour_Price;
        this.abbreviation = abbreviation;
        this.credit_Hours = credit_Hours;
        this.major_Minor = major_Minor;
        this.program_Department_ID = program_Department_ID;
    }

    public int getProgram_ID() {
        return program_ID;
    }

    public void setProgram_ID(int program_ID) {
        this.program_ID = program_ID;
    }

    public String getProgram_Name() {
        return program_Name;
    }

    public void setProgram_Name(String program_Name) {
        this.program_Name = program_Name;
    }

    public int getCredit_Hour_Price() {
        return credit_Hour_Price;
    }

    public void setCredit_Hour_Price(int credit_Hour_Price) {
        this.credit_Hour_Price = credit_Hour_Price;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getCredit_Hours() {
        return credit_Hours;
    }

    public void setCredit_Hours(int credit_Hours) {
        this.credit_Hours = credit_Hours;
    }

    public String getMajor_Minor() {
        return major_Minor;
    }

    public void setMajor_Minor(String major_Minor) {
        this.major_Minor = major_Minor;
    }

    public int getProgram_Department_ID() {
        return program_Department_ID;
    }

    public void setProgram_Department_ID(int program_Department_ID) {
        this.program_Department_ID = program_Department_ID;
    }

    @Override
    public String toString() {
        return  "Program ID: " + program_ID +
                ", Program Name: " + program_Name +
                ", Credit Hour Price: " + credit_Hour_Price +
                ", Abbreviation: " + abbreviation +
                ", Credit Hours: " + credit_Hours +
                ", Major Minor: " + major_Minor +
                ", Program Department ID: " + program_Department_ID;
    }
}
