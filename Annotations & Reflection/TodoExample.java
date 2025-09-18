import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Fix login bug", assignedTo = "Krishna")
    public void login() {}

    @Todo(task = "Add payment gateway", assignedTo = "Nitin", priority = "HIGH")
    public void payment() {}
}

public class TodoExample {
    public static void main(String[] args) {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo todo = m.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task() +
                        ", Assigned To: " + todo.assignedTo() +
                        ", Priority: " + todo.priority());
            }
        }
    }
}
