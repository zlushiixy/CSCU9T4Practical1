// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry(int d, int m, int y) {
    List<String> results = new ArrayList<>();
    for (Entry entry : tr) {
        if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
            results.add(entry.getEntry());
        }
    }
    if (results.isEmpty()) {
        return "No entries found for " + d + "/" + m + "/" + y;
    } else {
        return String.join("\n", results);
    }
}

// lookupEntry

   public String findAllEntries(int d, int m, int y) {
    List<String> results = new ArrayList<>();
    for (Entry entry : tr) {
        if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
            results.add(entry.getEntry());
        }
    }
    if (results.isEmpty()) {
        return "No entries found for " + d + "/" + m + "/" + y;
    } else {
        return String.join("\n", results);
    }
}

   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord