package Inheritance;



class Person {
 protected String name;
 protected int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public void displayDetails() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}


class Teacher extends Person {
 private String subject;

 public Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 public void displayRole() {
     System.out.println("Role: Teacher");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Subject: " + subject);
 }
}


class Student extends Person {
 private int grade;

 public Student(String name, int age, int grade) {
     super(name, age);
     this.grade = grade;
 }

 public void displayRole() {
     System.out.println("Role: Student");
 }

 
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Grade: " + grade);
 }
}


class Staff extends Person {
 private String department;

 public Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 public void displayRole() {
     System.out.println("Role: Staff");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Department: " + department);
 }
}


public class SchoolSystem{
 public static void main(String[] args) {
     Teacher teacher = new Teacher("Mr Amol Nagose ", 32, "Java");
     Student student = new Student("Ravi Kumar", 16, 10);
     Staff staff = new Staff("Mr. Verma", 35, "Administration");

     
     teacher.displayRole();
     teacher.displayDetails();


     student.displayRole();
     student.displayDetails();

    
     staff.displayRole();
     staff.displayDetails();
 }
}