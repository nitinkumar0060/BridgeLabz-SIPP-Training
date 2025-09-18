import java.util.regex.*;
public class ExtractEmails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Matcher m = Pattern.compile("[\\w.-]+@[\\w.-]+").matcher(text);
        while(m.find()) System.out.println(m.group());
    }
}
