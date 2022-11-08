package BankRedo;

public class BankAccount {
    private static int accountsCnt = 1;
    private static double interestRate = 0.02;

    private int id = 0;
    private double balance;


    public double getInterest(int years) {
        double result = balance * interestRate * years;
        return result;
    }
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit (int amount) {
        this.balance += amount;
    }

    public BankAccount() {
        this.id = accountsCnt++;
    }
    public int getID() {
        return this.id;
    }

}
