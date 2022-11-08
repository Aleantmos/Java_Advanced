package Bank;

public class BankAccount1 {
    private static int accountsCount = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount1() {
        this.id = accountsCount++;
    }

    public int getID() {
        return this.id;
    }

    public static void setInterestRate1(double interestRate) {
        BankAccount1.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}


