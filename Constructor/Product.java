package Constructor.Level1;
import java.util.*;
public class Product {
	String productName;
	double price;
	static int totalProducts=0;

	Product(String productName, double price){
		this.productName=productName;
		this.price=price;
		totalProducts++;
	}
	 public void displayProductDetails() {
	        System.out.println("Product Name: " + productName);
	        System.out.println("Price: :" + price);
	    }
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the product name ");
	    String productName =sc.next();
	    System.out.println("Enter the product price ");
	    double price=sc.nextDouble();
	    Product p1=new Product(productName,price);
	    System.out.println("Enter the product name ");
	    String productName1 =sc.next();
	    System.out.println("Enter the product price ");
	    double price1=sc.nextDouble();
	    Product p2=new Product(productName1,price1);
	    
	    p1. displayProductDetails();
	    System.out.println();
	    p2.displayProductDetails();
	    System.out.println("The total number of products is:" + totalProducts);
	    
		
		
		
	}
}