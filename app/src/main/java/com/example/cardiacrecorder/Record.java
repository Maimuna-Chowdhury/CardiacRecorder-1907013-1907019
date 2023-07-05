package com.example.cardiacrecorder;

public class Record {
    private String date,dyastolic,heart,systolic,time;
    private String childKey;
    public Record()
    {

    }

    public Record(String date, String dyastolic, String heart, String systolic, String time, String childKey) {
        this.date = date;
        this.dyastolic = dyastolic;
        this.heart = heart;
        this.systolic = systolic;
        this.time = time;
        this.childKey = childKey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDyastolic() {
        return dyastolic;
    }

    public void setDyastolic(String dyastolic) {
        this.dyastolic = dyastolic;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChildKey() {
        return childKey;
    }

    public void setChildKey(String childKey) {
        this.childKey = childKey;
    }
}
