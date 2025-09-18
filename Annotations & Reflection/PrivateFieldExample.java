import java.lang.reflect.*;

class Person {
    private int age = 20;
}

public class PrivateFieldExample {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Old Age: " + field.get(p));
        field.set(p, 30);
        System.out.println("New Age: " + field.get(p));
    }
}
