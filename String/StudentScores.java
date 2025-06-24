import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();

        int[] score = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

             for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
              sum += score[i];

            if (score[i] > max) {
                max = score[i];
            }

            if (score[i] < min) {
                min = score[i];
            }
        }

        double average =sum / n;
        System.out.println("Average Score: " + average);
        System.out.println("Maximum Score: " + max);
        System.out.println("Minimum Score: " + min);
        
    }
}