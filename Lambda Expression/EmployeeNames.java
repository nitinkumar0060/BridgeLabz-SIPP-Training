import java.util.*;

public class EmployeeNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ram", "shyam", "geeta");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
