import java.lang.reflect.*;

class Employee {
    public String name = "John";
    public int salary = 5000;
}

public class JsonExample {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":\"").append(f.get(obj)).append("\",");
        }
        sb.deleteCharAt(sb.length() - 1); // remove last comma
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Employee e = new Employee();
        System.out.println(toJson(e));
    }
}
