package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
    private int repetitions;
    private int recovery;

    public SprintEntry(String name, int day, int month, int year, int hours, int minutes, int seconds,
                       float distance, int repetitions, int recovery) {
        super(name, day, month, year, hours, minutes, seconds, distance);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    @Override
    public String getType() {
        return "Sprint";
    }

    @Override
    public String getDetails() {
        return "Distance: " + getDistance() + " meters, Repetitions: " + repetitions
                + ", Recovery: " + recovery + " minutes";
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getRecovery() {
        return recovery;
    }

    @Override
    public String getEntry() {
        String result = getName() + " sprinted " + repetitions + "x" + getDistance() + "m in "
                + String.format("%d:%02d:%02d", getHours(), getMinutes(), getSeconds())
                + " with " + recovery + " minutes recovery on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
        return result;
    }
}
