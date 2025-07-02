package Inheritance;




class BankAccount {
 protected String accountNumber;
 protected double balance;

 public BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 public void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: ₹" + balance);
 }
}

class SavingsAccount extends BankAccount {
 private double interestRate;

 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Savings Account");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}


class CheckingAccount extends BankAccount {
 private double withdrawalLimit;

 public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Checking Account");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
 }
}


class FixedDepositAccount extends BankAccount {
 private int durationMonths;

 public FixedDepositAccount(String accountNumber, double balance, int durationMonths) {
     super(accountNumber, balance);
     this.durationMonths = durationMonths;
 }

 public void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
 }


 public void displayDetails() {
     super.displayDetails();
     System.out.println("Duration: " + durationMonths + " months");
 }
}


public class BankAccountTypes {
 public static void main(String[] args) {
     SavingsAccount savings = new SavingsAccount("SAV123", 15000.0, 4.5);
     CheckingAccount checking = new CheckingAccount("CHK456", 8000.0, 25000.0);
     FixedDepositAccount fixed = new FixedDepositAccount("FD789", 100000.0, 12);

   
     savings.displayAccountType();
     savings.displayDetails();

     
     checking.displayAccountType();
     checking.displayDetails();


     fixed.displayAccountType();
     fixed.displayDetails();
 }
}