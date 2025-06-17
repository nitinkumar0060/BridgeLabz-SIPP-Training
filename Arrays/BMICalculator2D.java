
package Arrays;
import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        
        int number = scanner.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            while (true) {
                System.out.print("Enter height in meters: ");
                double height = scanner.nextDouble();
                if (height > 0) {
                    personData[i][0] = height;
                    break;
                } else {
                    System.out.println("Height must be positive. Please enter again.");
                }
            }

            while (true) {
                System.out.print("Enter weight in kilograms: ");
                double weight = scanner.nextDouble();
                if (weight > 0) {
                    personData[i][1] = weight;
                    break;
                } else {
                    System.out.println("Weight must be positive. Please enter again.");
                }
            }

            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
