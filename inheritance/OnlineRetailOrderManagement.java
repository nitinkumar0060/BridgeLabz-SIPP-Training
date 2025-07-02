package Inheritance;

public class OnlineRetailOrderManagement {
	
		 public static void main(String[] args) {
		     Order order = new Order("ORD123", "2025-06-30");
		     ShippedOrder shipped = new ShippedOrder("ORD124", "2025-06-28", "TRK456");
		     DeliveredOrder delivered = new DeliveredOrder("ORD125", "2025-06-25", "TRK789", "2025-06-29");

		     System.out.println("--- Order Status ---");
		     order.displayDetails();
		     System.out.println("Status: " + order.getOrderStatus());

		     System.out.println("\n--- Shipped Order Status ---");
		     shipped.displayDetails();
		     System.out.println("Status: " + shipped.getOrderStatus());

		     System.out.println("\n--- Delivered Order Status ---");
		     delivered.displayDetails();
		     System.out.println("Status: " + delivered.getOrderStatus());
		 }
		}




class Order {
  protected String orderId;
  protected String orderDate;

 public Order(String orderId, String orderDate) {
     this.orderId = orderId;
     this.orderDate = orderDate;
 }

 public String getOrderStatus() {
     return "Order placed";
 }

 public void displayDetails() {
     System.out.println("Order ID: " + orderId);
     System.out.println("Order Date: " + orderDate);
 }
}


class ShippedOrder extends Order {
 protected  String trackingNumber;

 public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
     super(orderId, orderDate);
     this.trackingNumber = trackingNumber;
 }


 public String getOrderStatus() {
     return "Order shipped with tracking number: " + trackingNumber;
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Tracking Number: " + trackingNumber);
 }
}


class DeliveredOrder extends ShippedOrder {
 protected String deliveryDate;

 public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);
     this.deliveryDate = deliveryDate;
 }


 public String getOrderStatus() {
     return "Order delivered on: " + deliveryDate;
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Delivery Date: " + deliveryDate);
 }
}