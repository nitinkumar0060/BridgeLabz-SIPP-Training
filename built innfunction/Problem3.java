import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Problem3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Format 1: " + today.format(format1));
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Format 2: " + today.format(format2));
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        System.out.println("Format 3: " + today.format(format3));
    }
}
