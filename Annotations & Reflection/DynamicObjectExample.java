class Student {
    String name = "Default Student";
}

public class DynamicObjectExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Object Created: " + obj);
        System.out.println("Class: " + obj.getClass().getName());
    }
}
