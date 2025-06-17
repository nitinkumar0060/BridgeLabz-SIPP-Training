import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        if (temperature <= 10 && windSpeed >= 4.8) {
            return 13.12 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed, 0.16)
                   + 0.3965 * temperature * Math.pow(windSpeed, 0.16);
        } else {
            System.out.println("Wind chill calculation is only valid for temperatures ≤ 10°C and wind speed ≥ 4.8 km/h.");
            return temperature;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed in km/h: ");
        double windSpeed = scanner.nextDouble();
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("The wind chill temperature is: %.2f°C%n", windChill);

    }
}
