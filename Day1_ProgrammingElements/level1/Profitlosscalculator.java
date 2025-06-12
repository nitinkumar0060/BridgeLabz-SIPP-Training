public class Profitlosscalculator {
public static void main(String[] args) {
int costPrice = 129;
int sellingPrice = 191;
System.out.println("The cost price is INR " + costPrice + ", selling price is INR " + sellingPrice);
int profit = sellingPrice - costPrice;
double profitPercentage = ((double) profit / costPrice) * 100;
System.out.println("The profit is INR " + profit + ", profit percentage is " + profitPercentage + "%");
    }
}