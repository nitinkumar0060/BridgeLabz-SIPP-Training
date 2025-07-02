class Student {
    public int rollNumber;
    protected String name; 
    private double CGPA;           

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Must be between 0 and 10.");
        }
    }

    public void displayInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {

    private String specialization;
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateInfo() {
        System.out.println("Postgraduate Student Info:");
        System.out.println("Name (Protected Access): " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA (Via Getter): " + getCGPA());
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Nitin", 8.5);
        s1.displayInfo();
        s1.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        System.out.println();

        PostgraduateStudent pg = new PostgraduateStudent(202, "Aman", 8.8, "Computer Science");
        pg.displayPostgraduateInfo();
    }
}
