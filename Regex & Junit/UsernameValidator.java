import java.util.regex.*;
public class UsernameValidator {
    public static void main(String[] args) {
        String[] tests = {"user_123", "123user", "us", "valid_User"};
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        for(String t : tests) {
            System.out.println(t + " → " + t.matches(regex));
        }
    }
}
