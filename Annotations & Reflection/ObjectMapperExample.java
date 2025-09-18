import java.lang.reflect.*;
import java.util.*;

class User {
    public String name;
    public int age;
}

public class ObjectMapperExample {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Field f : clazz.getDeclaredFields()) {
            if (props.containsKey(f.getName())) {
                f.setAccessible(true);
                f.set(obj, props.get(f.getName()));
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Krishna");
        map.put("age", 22);

        User u = toObject(User.class, map);
        System.out.println("User: " + u.name + ", Age: " + u.age);
    }
}
