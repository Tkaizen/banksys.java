import java.util.Scanner;

class BankAccount {
    String accountHolder;
    float accountBalance;

    // Constructor to initialize account holder and balance
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountBalance = 0.0f;
    }

    // Method to deposit money
    public void deposit(float amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + accountBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(float amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + accountBalance);
        } else if (amount > accountBalance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + accountBalance);
    }
}

class Bank {
    private BankAccount[] accounts;
    private int accountCount;

    // Constructor to initialize the bank with a fixed number of accounts
    public Bank(int maxAccounts) {
        accounts = new BankAccount[maxAccounts];
        accountCount = 0;
    }

    // Method to create a new account
    public void createAccount(String accountHolder) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = new BankAccount(accountHolder);
            accountCount++;
            System.out.println("Account created for " + accountHolder);
        } else {
            System.out.println("Sorry, the bank is at full capacity.");
        }
    }

    // Method to find an account by account holder's name
    public BankAccount findAccount(String accountHolder) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountHolder.equals(accountHolder)) {
                return accounts[i];
            }
        }
        return null;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank(10);  // Limit to 10 accounts for this example

        while (true) {
            System.out.println("\n--- Welcome to the Bank ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left over from nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    String name = scanner.nextLine();
                    bank.createAccount(name);
                    break;

                case 2:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    BankAccount account = bank.findAccount(name);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        float depositAmount = scanner.nextFloat();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    account = bank.findAccount(name);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        float withdrawAmount = scanner.nextFloat();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account holder's name: ");
                    name = scanner.nextLine();
                    account = bank.findAccount(name);
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the bank!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
