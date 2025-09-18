import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class StaticFieldExample {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Old Key: " + field.get(null));
        field.set(null, "NEW_SECRET_KEY");
        System.out.println("New Key: " + field.get(null));
    }
}
