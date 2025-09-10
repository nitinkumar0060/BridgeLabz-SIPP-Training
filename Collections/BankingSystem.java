import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    Map<String, Double> accounts = new HashMap<>();
    TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            double currentBalance = accounts.getOrDefault(request.accountNumber, 0.0);
            if (currentBalance >= request.amount) {
                updateBalance(request.accountNumber, currentBalance - request.amount);
                System.out.println("Withdrawal of ₹" + request.amount + " from " + request.accountNumber + " processed.");
            } else {
                System.out.println("Insufficient funds for " + request.accountNumber);
            }
        }
    }

    private void updateBalance(String accountNumber, double newBalance) {
        double oldBalance = accounts.get(accountNumber);
        accounts.put(accountNumber, newBalance);
        sortedByBalance.get(oldBalance).remove(accountNumber);
        if (sortedByBalance.get(oldBalance).isEmpty()) sortedByBalance.remove(oldBalance);
        sortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void displayAccounts() {
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + ": ₹" + entry.getValue());
        }
    }

    public void displaySortedAccounts() {
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + ": ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC001", 5000);
        bank.addAccount("ACC002", 12000);
        bank.addAccount("ACC003", 8000);

        bank.requestWithdrawal("ACC001", 2000);
        bank.requestWithdrawal("ACC002", 15000);
        bank.requestWithdrawal("ACC003", 3000);

        System.out.println("Processing Withdrawals:");
        bank.processWithdrawals();

        System.out.println("\nAll Accounts:");
        bank.displayAccounts();

        System.out.println("\nAccounts Sorted by Balance:");
        bank.displaySortedAccounts();
    }
}
