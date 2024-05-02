package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {
    private String terrain;
    private String tempo;

    public CycleEntry(String name, int day, int month, int year, int hours, int minutes, int seconds,
                      float distance, String terrain, String tempo) {
        super(name, day, month, year, hours, minutes, seconds, distance);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    @Override
    public String getType() {
        return "Cycle";
    }

    @Override
    public String getDetails() {
        return "Distance: " + getDistance() + " km, Terrain: " + terrain + ", Tempo: " + tempo;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getTempo() {
        return tempo;
    }

    @Override
    public String getEntry() {
        String result = getName() + " cycled " + getDistance() + " km in "
                + String.format("%d:%02d:%02d", getHours(), getMinutes(), getSeconds())
                + " on " + getDay() + "/" + getMonth() + "/" + getYear()
                + " on " + terrain + " at " + tempo + " tempo\n";
        return result;
    }
}
