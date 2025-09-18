import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList("Emergency", "Appointment", "Reminder", "Promotion");

        Predicate<String> isImportant = alert -> !alert.equals("Promotion");

        alerts.stream()
                .filter(isImportant)
                .forEach(System.out::println);
    }
}
