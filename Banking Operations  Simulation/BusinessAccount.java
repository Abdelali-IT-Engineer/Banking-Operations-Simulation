public class BusinessAccount extends BankAccount {
    private static final double TRANSACTION_FEE = 2.5;

    public BusinessAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double totalAmount = amount + TRANSACTION_FEE;
        if (totalAmount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal with transaction fee.");
        } else {
            balance -= totalAmount;
            System.out.println("Withdrawn: $" + amount + " (Fee: $" + TRANSACTION_FEE + ")");
        }
    }
}
