import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AttendanceSystem {
    private Map<Integer, String> idToNameMap; // Map to store ID-to-Name mapping
    private Set<String> attendanceSet; // Set to store unique attendance

    public AttendanceSystem() {
        idToNameMap = new HashMap<>();
        attendanceSet = new HashSet<>();
    }

    // Method to swipe ID and take attendance
    public void swipeID(int id) {
        if (idToNameMap.containsKey(id)) {
            String studentName = idToNameMap.get(id);
            attendanceSet.add(studentName);
            System.out.println(studentName + " attendance recorded.");
        } else {
            System.out.println("ID " + id + " not found in the system.");
        }
    }

    // Method to add student to the system
    public void addStudent(int id, String name) {
        idToNameMap.put(id, name);
        System.out.println(name + " added to the system with ID: " + id);
    }

    // Method to print attendance at the end of the day
    public void printAttendance() {
        System.out.println("Attendance for the day:");
        for (String studentName : attendanceSet) {
            System.out.println(studentName);
        }
    }

     // Getter for idToNameMap
     public Map<Integer, String> getIdToNameMap() {
        return idToNameMap;
    }

    // Getter for attendanceSet
    public Set<String> getAttendanceSet() {
        return attendanceSet;
    }
}


