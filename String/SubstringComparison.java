import java.util.Scanner;

public class SubstringComparison {
    public static String createSubstringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();

        System.out.print("Enter the start index: ");
        int start = sc.nextInt();

        System.out.print("Enter the end index: ");
        int end = sc.nextInt();
        String manualSubstring = createSubstringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        boolean isEqual = compareStringsUsingCharAt(manualSubstring, builtInSubstring);
        System.out.println("\nManual Substring using charAt(): " + manualSubstring);
        System.out.println("Built-in Substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
