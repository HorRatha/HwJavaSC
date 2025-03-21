package bankingHW;

import bankingHW.model.SavingAccount;
import bankingHW.model.CreditCardAccount;
import bankingHW.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("\n Welcome to the Banking System");
            System.out.println("1 - Create Account");
            System.out.println("2 - Log in");
            System.out.println("3 - Exit");
            System.out.print("🔹 Enter choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exitProgram = true;
                    System.out.println("[+] Exiting Banking System. Thank you!");
                    break;
                default:
                    System.out.println("[+] Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void createAccount() {
        System.out.println("\n🔹 Select Account Type:");
        System.out.println("1 - Saving Account");
        System.out.println("2 - Credit Card Account");
        System.out.print("🔹 Enter choice: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("+ Enter your name: ");
        String accountName = scanner.nextLine();

        int pin;
        while (true) {
            System.out.print("+ Set a 4-digit PIN: ");
            pin = scanner.nextInt();
            if (String.valueOf(pin).length() == 4) {
                break;
            } else {
                System.out.println("[+] Invalid PIN. Please enter a 4-digit PIN.");
            }
        }

        if (accountType == 1) {
            accounts.add(new SavingAccount(accountName, pin));
            System.out.println("[+] Saving Account Created Successfully!");
        } else if (accountType == 2) {
            System.out.print("💳 Set Credit Limit (e.g., 500): ");
            double creditLimit = scanner.nextDouble();
            accounts.add(new CreditCardAccount(accountName, pin, creditLimit));
            System.out.println("[+] Credit Card Account Created Successfully!");
        } else {
            System.out.println("[+] Invalid type. Try again.");
        }
    }

    private static void login() {
        System.out.print("\n Enter your name: ");
        String accountName = scanner.nextLine();

        System.out.print("+ Enter your PIN: ");
        int pin = scanner.nextInt();

        Account userAccount = null;
        for (Account acc : accounts) {
            if (acc.accountName.equals(accountName) && acc.authenticate(pin)) {
                userAccount = acc;
                break;
            }
        }

        if (userAccount != null) {
            System.out.println("[+] Login successful!");
            bankingMenu(userAccount);
        } else {
            System.out.println("[+] Incorrect credentials. Try again.");
        }
    }

    private static void bankingMenu(Account account) {
        boolean exitAccountMenu = false;

        while (!exitAccountMenu) {
            System.out.println("\n🔹 Choose an action:");


            if (!(account instanceof CreditCardAccount)) {
                System.out.println("1 - Deposit");
            }

            System.out.println("2 - Withdraw");
            System.out.println("3 - Show Balance");
            System.out.println("4 - Convert USD to Riel");
            System.out.println("5 - Convert Riel to USD");
            System.out.println("6 - Log out");
            System.out.print("🔹 Enter choice: ");
            int actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    if (account instanceof CreditCardAccount) {
                        System.out.println("[+] Cannot deposit into a Credit Card account!");
                    } else {
                        System.out.print("+ Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;
                case 2:
                    System.out.print(" Enter transaction amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    System.out.print("+ Enter amount in USD: ");
                    double usdToConvert = scanner.nextDouble();
                    account.convertFromDollarToRiel(usdToConvert);
                    break;
                case 5:
                    System.out.print("+ Enter amount in Riel: ");
                    double rielToConvert = scanner.nextDouble();
                    account.convertFromRielToDollar(rielToConvert);
                    break;
                case 6:
                    exitAccountMenu = true;
                    System.out.println("\n[+] Logged out successfully!\n");
                    break;
                default:
                    System.out.println("[+] Invalid selection. Try again.");
            }
        }
    }
}
