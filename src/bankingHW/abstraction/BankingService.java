package bankingHW.abstraction;

public interface BankingService {
    void deposit(Double cashAmount);
    void withdraw(Double cashAmount);
    void showBalance();
    void convertFromDollarToRiel(Double dollar);
    void convertFromRielToDollar(Double riel);
}