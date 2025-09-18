import java.lang.reflect.*;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodExample {
    public static void main(String[] args) throws Exception {
        MathOperations math = new MathOperations();

        String methodName = "multiply"; // user input
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

        int result = (int) method.invoke(math, 10, 5);
        System.out.println("Result: " + result);
    }
}
