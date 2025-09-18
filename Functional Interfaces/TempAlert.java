import java.util.function.Predicate;

public class TempAlert {
    public static void main(String[] args) {
        Predicate<Double> isHighTemp = temp -> temp > 37.5;
        System.out.println(isHighTemp.test(39.0) ? "ALERT: High Temperature!" : "Normal");
    }
}
