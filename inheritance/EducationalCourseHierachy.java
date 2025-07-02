package Inheritance;

class Course {
    protected String courseName;
    protected int duration; 

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
    }
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Sessions: " + (isRecorded ? "Yes" : "No"));
    }
}
class PaidOnlineCourse extends OnlineCourse {
    protected double fee;
    protected double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee After Discount: ₹" + getDiscountedFee());
    }
}public class EducationalCourseHierachy {
    public static void main(String[] args) {
        Course basic = new Course("Introduction to Programming", 6);
        OnlineCourse online = new OnlineCourse("Data Structures", 8, "Coursera", true);
        PaidOnlineCourse paid = new PaidOnlineCourse("Full Stack Development", 12, "Udemy", true, 9999.0, 20.0);

     
        basic.displayDetails();

     
        online.displayDetails();

      
        paid.displayDetails();
    }
}