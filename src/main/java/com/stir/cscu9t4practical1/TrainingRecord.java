// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<TrainingSession> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<>();
    } //constructor
    
    // add a record to the list
   public void addEntry(TrainingSession session){
       tr.add(session);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry(int d, int m, int y) {
    List<String> results = new ArrayList<>();
    for (TrainingSession entry : tr) {
        if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
            results.add(((Entry) entry).getEntry());
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
    for (TrainingSession entry : tr) {
        if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
            results.add(((Entry) entry).getEntry());
        }
    }
    if (results.isEmpty()) {
        return "No entries found for " + d + "/" + m + "/" + y;
    } else {
        return String.join("\n", results);
    }
}

// Remove an entry based on name and date
public boolean removeEntry(String name, int d, int m, int y) {
    Iterator<TrainingSession> iterator = tr.iterator();
    while (iterator.hasNext()) {
        Entry entry = (Entry) iterator.next();
        if (entry.getName().equalsIgnoreCase(name) && entry.getDay() == d
                && entry.getMonth() == m && entry.getYear() == y) {
            iterator.remove();
            return true; // Entry removed successfully
        }
    }
    return false; // Entry not found
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