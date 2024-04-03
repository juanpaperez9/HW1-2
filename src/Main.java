public class Main {
    public static void main(String[] args) {
        AttendanceSystem attendanceSystem = new AttendanceSystem();

        // Adding students to the system
        attendanceSystem.addStudent(1, "John");
        attendanceSystem.addStudent(2, "Alice");
        attendanceSystem.addStudent(3, "Bob");

        // Simulating swiping IDs for attendance
        attendanceSystem.swipeID(1);
        attendanceSystem.swipeID(2);
        attendanceSystem.swipeID(1); // John swipes again

        // Printing attendance at the end of the day
        attendanceSystem.printAttendance();
    }
}