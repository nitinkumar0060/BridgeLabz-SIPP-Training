import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String title;

    public CourseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }

    public void evaluate() {
        System.out.println(getTitle() + " is evaluated through exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }

    public void evaluate() {
        System.out.println(getTitle() + " is evaluated through assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }

    public void evaluate() {
        System.out.println(getTitle() + " is evaluated through research work.");
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void showEvaluationMethod() {
        courseType.evaluate();
    }
}

class CourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        List<CourseType> courseList = new ArrayList<>();

        courseList.add(new ExamCourse("Mathematics"));
        courseList.add(new AssignmentCourse("Literature"));
        courseList.add(new ResearchCourse("Physics"));

        CourseManager.displayCourses(courseList);
    }
}
