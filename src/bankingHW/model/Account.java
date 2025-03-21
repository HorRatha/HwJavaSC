package bankingHW.model;

import bankingHW.abstraction.BankingService;

public abstract class Account implements BankingService {
    public String accountName;
    protected Double balance = 0.0;
    protected Double rielBalance = 0.0;
    private int pin;
    private static final double EXCHANGE_RATE = 4000;

    public Account(String accountName, int pin) {
        this.accountName = accountName;
        this.pin = pin;
    }

    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    @Override
    public void deposit(Double cashAmount) {
        if (cashAmount <= 0) {
            System.out.println("[!] Invalid deposit amount.");
            return;
        }
        balance += cashAmount;
        System.out.println("[+] Deposited: $" + cashAmount);
        showBalance();
    }

    @Override
    public void withdraw(Double cashAmount) {
        if (cashAmount > balance) {
            System.out.println("[!] Insufficient funds. Current balance: $" + balance);
            return;
        }
        balance -= cashAmount;
        System.out.println("[+] Withdrawn: $" + cashAmount);
        showBalance();
    }

    @Override
    public void showBalance() {
        System.out.println("[+] Account: " + accountName + " | USD Balance: $" + balance + " | Riel Balance: " + rielBalance + " Riels");
    }

    @Override
    public void convertFromDollarToRiel(Double dollar) {
        if (dollar > balance) {
            System.out.println("[!] Insufficient USD balance.");
            return;
        }
        balance -= dollar;
        double riel = dollar * EXCHANGE_RATE;
        rielBalance += riel;
        System.out.println("[+] Converted: $" + dollar + " to " + riel + " Riels");
        showBalance();
    }

    @Override
    public void convertFromRielToDollar(Double riel) {
        if (riel > rielBalance) {
            System.out.println("[!] Insufficient Riel balance.");
            return;
        }
        rielBalance -= riel;
        double dollar = riel / EXCHANGE_RATE;
        balance += dollar;
        System.out.println("[+] Converted: " + riel + " Riels to $" + dollar);
        showBalance();
    }
}
