public class CensorWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String regex = "(damn|stupid)";
        String output = input.replaceAll(regex, "****");
        System.out.println(output);
    }
}
