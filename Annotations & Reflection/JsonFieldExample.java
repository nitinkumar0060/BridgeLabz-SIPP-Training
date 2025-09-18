import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    String name = "Krishna";

    @JsonField(name = "user_age")
    int age = 22;
}

public class JsonFieldExample {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        StringBuilder sb = new StringBuilder("{");

        for (Field f : Person.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                sb.append("\"").append(jf.name()).append("\":\"").append(f.get(p)).append("\",");
            }
        }
        sb.deleteCharAt(sb.length() - 1).append("}");
        System.out.println(sb);
    }
}
