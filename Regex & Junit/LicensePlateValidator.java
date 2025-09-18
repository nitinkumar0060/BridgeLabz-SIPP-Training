public class LicensePlateValidator {
    public static void main(String[] args) {
        String[] tests = {"AB1234", "A12345", "XY9876"};
        String regex = "^[A-Z]{2}[0-9]{4}$";
        for(String t : tests) {
            System.out.println(t + " → " + t.matches(regex));
        }
    }
}
