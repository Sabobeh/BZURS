package com.example.bzurs;

import javafx.scene.control.Button;

public class SectionData {
    private Button section_id;
    private String professor_name;
    private String time;
    private String capacity;
    private int timeperiod_id;

    public SectionData(Button section_id, String professor_name, String time, String capacity, int timeperiod_id) {
        this.section_id = section_id;
        this.professor_name = professor_name;
        this.time = time;
        this.capacity = capacity;
        this.timeperiod_id = timeperiod_id;
    }

    public Button getSection_id() {
        return section_id;
    }

    public void setSection_id(Button section_id) {
        this.section_id = section_id;
    }

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getTimeperiod_id() {
        return timeperiod_id;
    }

    public void setTimeperiod_id(int timeperiod_id) {
        this.timeperiod_id = timeperiod_id;
    }
}
