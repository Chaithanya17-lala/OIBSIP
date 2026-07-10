import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    
    public boolean validatePin(String inputPin) { return this.pin.equals(inputPin); }
    
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public void addTransferLog(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount));
    }

    public void printHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions in this session.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }
}
