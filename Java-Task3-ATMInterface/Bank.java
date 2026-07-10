import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Pre-populating 2 test accounts (User ID, PIN, Initial Balance)
        accounts.put("user123", new Account("user123", "1111", 1000.00));
        accounts.put("user456", new Account("user456", "2222", 500.00));
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }
}
