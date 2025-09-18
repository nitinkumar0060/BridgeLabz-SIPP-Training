public class HexColorValidator {
    public static void main(String[] args) {
        String[] tests = {"#FFA500", "#ff4500", "#123"};
        String regex = "^#([A-Fa-f0-9]{6})$";
        for(String t : tests) {
            System.out.println(t + " → " + t.matches(regex));
        }
    }
}
