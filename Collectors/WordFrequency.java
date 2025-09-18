import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is great and Java is powerful";
        String[] words = paragraph.split("\\s+");

        Map<String, Long> wordCount = Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w.toLowerCase(), Collectors.counting()));

        System.out.println(wordCount);
    }
}
