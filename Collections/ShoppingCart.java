import java.util.*;

class ShoppingCart {
    Map<String, Double> priceMap = new HashMap<>();
    Map<String, Double> cartOrder = new LinkedHashMap<>();
    TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        cartOrder.put(product, price);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    public void displayCartInOrder() {
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + ": ₹" + entry.getValue());
        }
    }

    public void displayCartSortedByPrice() {
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + ": ₹" + entry.getKey());
            }
        }
    }

    public void displayPriceOf(String product) {
        System.out.println(product + ": ₹" + priceMap.getOrDefault(product, 0.0));
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 75000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);
        cart.addProduct("Monitor", 12000);
        cart.addProduct("USB Cable", 300);

        System.out.println("Cart in Order of Addition:");
        cart.displayCartInOrder();

        System.out.println("\nCart Sorted by Price:");
        cart.displayCartSortedByPrice();

        System.out.println("\nPrice of Keyboard:");
        cart.displayPriceOf("Keyboard");
    }
}
