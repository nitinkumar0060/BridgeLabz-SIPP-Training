import java.util.*;
import java.util.stream.*;

public class NameTransform {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "ravi", "neha", "sneha");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}
