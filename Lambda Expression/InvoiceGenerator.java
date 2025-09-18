import java.util.*;

class Invoice {
    int transactionId;

    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice for Transaction ID: " + transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        List<Integer> transactionIds = Arrays.asList(1001, 1002, 1003);

        transactionIds.stream()
                .map(Invoice::new) // constructor reference
                .forEach(System.out::println);
    }
}
