import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(String inputDate) {
        LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

public class DateFormatDemo {
    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate("2025-09-18"));
    }
}
