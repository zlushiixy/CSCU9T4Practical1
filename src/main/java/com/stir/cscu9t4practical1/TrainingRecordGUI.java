// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
// import java.util.*;
import javax.swing.*;
// import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField type = new JTextField(4);
    private JTextField where = new JTextField(30);
    private JTextField rep = new JTextField(2);
    private JTextField recov = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labw = new JLabel(" Where:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labrep = new JLabel(" Repetitions:");
    private JLabel labrecov = new JLabel(" Recovery:");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    // Add a new button to find all entries by date
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton removeButton = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();
    private JRadioButton runRadioButton = new JRadioButton("Run");
    private JRadioButton cycleRadioButton = new JRadioButton("Cycle");
    private JRadioButton swimRadioButton = new JRadioButton("Swim");
    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(type);
        type.setEditable(true);
        add(where);
        add(labw);
        add(labrep); // Add label for repetitions
        add(rep); // Add field for repetitions
        add(labrecov); // Add label for recovery
        add(recov); // Add field for recovery
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        // Add FindAllByDate button to the GUI
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        // Add radio buttons for selecting session type
        ButtonGroup sessionTypeGroup = new ButtonGroup();
        sessionTypeGroup.add(runRadioButton);
        sessionTypeGroup.add(cycleRadioButton);
        sessionTypeGroup.add(swimRadioButton);
        add(runRadioButton);
        add(cycleRadioButton);
        add(swimRadioButton);

        // Add ActionListener for radio buttons
        runRadioButton.addActionListener(this);
        cycleRadioButton.addActionListener(this);
        swimRadioButton.addActionListener(this);

        add(removeButton);
        removeButton.addActionListener(this);

        setSize(720, 400);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        } else if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        } else if (event.getSource() == findAllByDate) {
            message = findAllEntriesByDate();
        }
        else if (event.getSource() == removeButton) {
             message = removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();

        // Handle radio button selection
        if (event.getSource() == runRadioButton) {
            type.setEnabled(true); // Enable distance field for runs
        } else if (event.getSource() == cycleRadioButton) {
            type.setEnabled(true); // Enable distance field for cycles
        } else if (event.getSource() == swimRadioButton) {
            type.setEnabled(true); // Enable distance field for swims
        }
    } // actionPerformed

    

    public String findAllEntriesByDate() {
        String message;
        try {
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());
            
            // Validate day, month, year values
            if (isValidDate(d, m, y)) {
                outputArea.setText("Finding all entries for " + d + " " + m + " " + y + " ...");
                message = myAthletes.lookupEntry(d, m, y);
            } else {
                message = "Invalid date. Please enter a valid date (DD MM YYYY).";
            }
        } catch (NumberFormatException e) {
            message = "Invalid input for date. Please enter numeric values for day, month, and year.";
        }
        return message;
    }
    
    private boolean isValidDate(int day, int month, int year) {
        // Validate day, month, year based on calendar rules
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }
    
    private int daysInMonth(int month, int year) {
        // Calculate number of days in a given month and year
        switch (month) {
            case 2:
                return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    

    public String addEntry(String what) {
        String message = "Record added\n";
        try {
            String n = name.getText().trim();
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());
            float km = Float.parseFloat(type.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            String w = where.getText().trim();
            int r = Integer.parseInt(rep.getText());
            int rec = Integer.parseInt(recov.getText());

            TrainingSession session;
            if (runRadioButton.isSelected()) {
                session = new SprintEntry(n, d, m, y, h, mm, s, km, r, rec );
            } else if (cycleRadioButton.isSelected()) {
                session = new CycleEntry(n, d, m, y, h, mm, s, km, "Road", "moderate"); // Example terrain and time
            } else if (swimRadioButton.isSelected()) {
                
                session = new SwimEntry(n, d, m, y, h, mm, s, km, w); // Example: pool swim
            } else {
                session = new Entry(n, d, m, y, h, mm, s, km); // Default to general entry
            }

            myAthletes.addEntry(session);
        } catch (NumberFormatException e) {
            message = "Invalid input. Please ensure all fields are filled with valid values.";
        }
        return message;
    }

public String removeEntry() {
    String message = "Entry removed\n";
    try {
        String n = name.getText().trim();
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());

        // Call method to remove entry from TrainingRecord
        boolean removed = myAthletes.removeEntry(n, d, m, y);
        if (!removed) {
            message = "Entry not found";
        }
    } catch (NumberFormatException e) {
        message = "Invalid input. Please ensure date fields are filled with valid values.";
    }
    return message;
}

    
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        type.setText("");
        where.setText("");
        rep.setText("");
        recov.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHours()));
        mins.setText(String.valueOf(ent.getMinutes()));
        secs.setText(String.valueOf(ent.getSeconds()));
        type.setText(String.valueOf(ent.getType()));
    }

} // TrainingRecordGUI

