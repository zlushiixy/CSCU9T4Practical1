package com.stir.cscu9t4practical1;

public abstract class TrainingSession {
    protected String name;
    protected int day;
    protected int month;
    protected int year;
    protected int hours;
    protected int minutes;
    protected int seconds;

    public TrainingSession(String name, int day, int month, int year, int hours, int minutes, int seconds) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public abstract String getType(); // Abstract method to get the type of training session

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public abstract String getDetails(); // Abstract method to get specific details of the session
}
