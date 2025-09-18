import java.util.*;

public class EventAttendees {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Amit", "Ravi", "Neha");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "!"));
    }
}
