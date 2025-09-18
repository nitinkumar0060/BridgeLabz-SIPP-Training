interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}

public class PasswordCheck {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Pass1234"));
    }
}
