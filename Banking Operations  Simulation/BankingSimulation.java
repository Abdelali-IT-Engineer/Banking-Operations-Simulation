import java.util.Scanner;

public class BankingSimulation {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("John Doe", 1000);
        BankAccount checking = new CheckingAccount("Jane Smith", 2000);
        BankAccount business = new BusinessAccount("Acme Corp", 5000);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            System.out.println("Choose account type:");
            System.out.println("1. Savings");
            System.out.println("2. Checking");
            System.out.println("3. Business");
            int accountType = scanner.nextInt();

            BankAccount selectedAccount = switch (accountType) {
                case 1 -> savings;
                case 2 -> checking;
                case 3 -> business;
                default -> null;
            };

            if (selectedAccount == null) {
                System.out.println("Invalid account type!");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        selectedAccount.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        selectedAccount.withdraw(withdrawalAmount);
                    }
                    case 3 -> System.out.println("Balance: $" + selectedAccount.getBalance());
                    case 4 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
