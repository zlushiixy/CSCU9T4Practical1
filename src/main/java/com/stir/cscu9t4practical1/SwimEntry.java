package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {
    private String where;

    public SwimEntry(String name, int day, int month, int year, int hours, int minutes, int seconds,
                     float distance, String where) {
        super(name, day, month, year, hours, minutes, seconds, distance);
        this.where = where;
    }

    @Override
    public String getType() {
        return "Swim";
    }

    @Override
    public String getDetails() {
        return "Distance: " + getDistance() + " km, Location: " + where;
    }

    public String getWhere() {
        return where;
    }

    @Override
    public String getEntry() {
        String location = where.equals("pool") ? "in a pool" : "outdoors";
        String result = getName() + " swam " + getDistance() + " km " + location + " in "
                + String.format("%d:%02d:%02d", getHours(), getMinutes(), getSeconds())
                + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
