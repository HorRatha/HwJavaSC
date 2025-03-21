package bankingHW.model;

public class CreditCardAccount extends Account {
    private final double creditLimit = 500.0;

    public CreditCardAccount(String accountName, int pin, double creditLimit) {
        super(accountName, pin);
    }

    @Override
    public void deposit(Double cashAmount) {
        System.out.println("[+] Deposit is not allowed for Credit Card accounts!");
    }

    @Override
    public void withdraw(Double cashAmount) {
        double availableCredit = balance + creditLimit;

        if (cashAmount > availableCredit) {
            System.out.println("[+] Transaction failed! Exceeded credit limit of $500.");
            return;
        }

        balance -= cashAmount;
        System.out.println("[+] Transaction successful! Spent: $" + cashAmount);
        showBalance();
    }

    @Override
    public void showBalance() {
        System.out.println("\n[+] Credit Card Account: " + accountName);
        System.out.println("[+] Current Balance: $" + balance);
        System.out.println("[+] Remaining Credit Limit: $" + (creditLimit + balance));
    }
}