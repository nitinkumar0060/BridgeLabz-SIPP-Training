import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Login issue")
    @BugReport(description = "Slow response on dashboard")
    public void run() {}
}

public class RepeatableExample {
    public static void main(String[] args) throws Exception {
        Method m = Software.class.getMethod("run");
        BugReport[] reports = m.getAnnotationsByType(BugReport.class);

        for (BugReport r : reports) {
            System.out.println("Bug: " + r.description());
        }
    }
}
