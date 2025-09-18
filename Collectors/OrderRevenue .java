import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;
    Order(String customer, double total) {
        this.customer = customer; this.total = total;
    }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Amit", 1200),
            new Order("Ravi", 1500),
            new Order("Amit", 800),
            new Order("Sneha", 2000)
        );

        Map<String, Double> revenue = orders.stream()
            .collect(Collectors.groupingBy(o -> o.customer,
                     Collectors.summingDouble(o -> o.total)));

        System.out.println(revenue);
    }
}
