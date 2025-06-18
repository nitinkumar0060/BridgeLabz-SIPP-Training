package Arrays;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = scanner.nextInt ();

        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        char[] grade = new char[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                System.out.print("Enter marks in " + subject + ": ");
                int mark = scanner.nextInt();

                if (mark < 0) {
                    System.out.println("Invalid input! Marks cannot be negative. Re-enter all marks for this student.");
                    i--;
                    break;
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        for (int i = 0; i < number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Student %d: Physics = %d, Chemistry = %d, Maths = %d, Percentage = %.2f%%, Grade = %c%n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

       
    }
}