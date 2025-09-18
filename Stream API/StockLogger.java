import java.util.*;

public class StockLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(120.5, 122.8, 119.9, 123.7);
        prices.forEach(p -> System.out.println("Stock Price: " + p));
    }
}
