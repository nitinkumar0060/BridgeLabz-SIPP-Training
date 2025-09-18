import java.util.*;

public class SuppressExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();  // no generics
        list.add("Hello");
        list.add(123);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
