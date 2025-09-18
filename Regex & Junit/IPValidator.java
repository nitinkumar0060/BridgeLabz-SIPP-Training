public class IPValidator {
    public static void main(String[] args) {
        String[] tests = {"192.168.0.1", "256.100.50.25", "10.0.0.256"};
        String regex = "^((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.|$)){4}$";
        for(String t : tests) System.out.println(t + " → " + t.matches(regex));
    }
}
