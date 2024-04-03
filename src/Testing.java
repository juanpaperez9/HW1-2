import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Testing {

@Test
    public void testAddStudent() {
        AttendanceSystem attendanceSystem = new AttendanceSystem();
        attendanceSystem.addStudent(1, "John");
        attendanceSystem.addStudent(2, "Alice");

        assertTrue(attendanceSystem.getIdToNameMap().containsKey(1));
        assertTrue(attendanceSystem.getIdToNameMap().containsKey(2));
        assertFalse(attendanceSystem.getIdToNameMap().containsKey(3));
    }

    @Test
    public void testSwipeID() {
        AttendanceSystem attendanceSystem = new AttendanceSystem();
        attendanceSystem.addStudent(1, "John");
        attendanceSystem.addStudent(2, "Alice");

        attendanceSystem.swipeID(1);
        attendanceSystem.swipeID(2);
        attendanceSystem.swipeID(1); // John swipes again

        assertEquals(2, attendanceSystem.getAttendanceSet().size());
        assertTrue(attendanceSystem.getAttendanceSet().contains("John"));
        assertTrue(attendanceSystem.getAttendanceSet().contains("Alice"));
    }

    @Test
public void testPrintAttendance() {
    AttendanceSystem attendanceSystem = new AttendanceSystem();
    attendanceSystem.addStudent(1, "John");
    attendanceSystem.addStudent(2, "Alice");

    attendanceSystem.swipeID(1);
    attendanceSystem.swipeID(2);
    attendanceSystem.swipeID(1); // John swipes again

    // Redirect output stream to capture printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    attendanceSystem.printAttendance();

    // Restore original output stream
    System.setOut(System.out);

    String expectedOutput = "Attendance for the day:\n" +
                            "Alice\n" +
                            "John\n";
    String actualOutput = outputStream.toString();
    
    // Split the strings into lists of lines
    List<String> expectedLines = Arrays.asList(expectedOutput.split("\\r?\\n"));
    List<String> actualLines = Arrays.asList(actualOutput.split("\\r?\\n"));
    
    // Sort the lists to make order irrelevant
    Collections.sort(expectedLines);
    Collections.sort(actualLines);
    
    // Compare the sorted lists
    assertEquals(expectedLines, actualLines);
}

}

