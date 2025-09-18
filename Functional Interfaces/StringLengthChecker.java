import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunc = str -> str.length();
        System.out.println("Length: " + lengthFunc.apply("Hello World"));
    }
}
