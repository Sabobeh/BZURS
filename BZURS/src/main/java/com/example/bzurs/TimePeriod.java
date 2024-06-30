package com.example.bzurs;

public class TimePeriod {
    private int timePeriod_ID;
    private String dayComb;
    private String timeComb;
    private int courseType;

    public TimePeriod(int timePeriod_ID, String dayComb, String timeComb, int courseType) {
        this.timePeriod_ID = timePeriod_ID;
        this.dayComb = dayComb;
        this.timeComb = timeComb;
        this.courseType = courseType;
    }

    public int getTimePeriod_ID() {
        return timePeriod_ID;
    }

    public void setTimePeriod_ID(int timePeriod_ID) {
        this.timePeriod_ID = timePeriod_ID;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public String getDayComb() {
        return dayComb;
    }

    public void setDayComb(String dayComb) {
        this.dayComb = dayComb;
    }

    public String getTimeComb() {
        return timeComb;
    }

    public void setTimeComb(String timeComb) {
        this.timeComb = timeComb;
    }

    @Override
    public String toString() {
        return  "Day Combination: " + dayComb +
                ", Time Combination: " + timeComb;
    }
}
