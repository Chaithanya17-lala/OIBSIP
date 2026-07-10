import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Account currentAccount;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== ATM SYSTEM INITIALIZED ===");
        int loginAttempts = 0;

        while (loginAttempts < 3) {
            System.out.print("Enter User ID: ");
            String userId = scanner.next();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            Account acc = bank.getAccount(userId);
            if (acc != null && acc.validatePin(pin)) {
                currentAccount = acc;
                System.out.println("\n✅ Login Successful!");
                showMenu();
                return;
            } else {
                loginAttempts++;
                System.out.println("❌ Invalid credentials. Attempts remaining: " + (3 - loginAttempts));
            }
        }
        System.out.println("🔒 Access Denied. Account locked due to too many failed attempts.");
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- Transaction History ---");
                    currentAccount.printHistory();
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double wAmount = scanner.nextDouble();
                    if (currentAccount.withdraw(wAmount)) {
                        System.out.println("💸 Dispensing cash. Current balance: $" + currentAccount.getBalance());
                    } else {
                        System.out.println("⚠️ Insufficient Funds.");
                    }
                    break;
                case 3:
                    System.out.print("Enter deposit amount: $");
                    double dAmount = scanner.nextDouble();
                    currentAccount.deposit(dAmount);
                    System.out.println("💵 Deposit recorded. Current balance: $" + currentAccount.getBalance());
                    break;
                case 4:
                    System.out.print("Enter recipient Account ID: ");
                    String recipientId = scanner.next();
                    Account recipient = bank.getAccount(recipientId);
                    
                    if (recipient == null) {
                        System.out.println("❌ Recipient account not found.");
                        break;
                    }
                    System.out.print("Enter transfer amount: $");
                    double tAmount = scanner.nextDouble();
                    
                    if (currentAccount.withdraw(tAmount)) {
                        recipient.deposit(tAmount);
                        currentAccount.addTransferLog("Transferred to " + recipientId, tAmount);
                        System.out.println("✅ Transfer successful!");
                    } else {
                        System.out.println("⚠️ Insufficient Funds.");
                    }
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
