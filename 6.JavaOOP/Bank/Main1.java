package Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    //TODO Finish
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount1> vault = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String output;

            switch (tokens[0]) {
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    vault.get(id).deposit(amount);
                    output = "Deposited " + amount + " to ID" + id;
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[2]);
                    BankAccount1.setInterestRate1(newInterest);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    double interest = vault.get(id).getInterest(years);
                    output = String.format("%.2f", interest);
                    break;
                default:
                    BankAccount1 bankAccount = new BankAccount1();
                    vault.put(bankAccount.getID(), bankAccount);
                    output = "Account ID" + bankAccount.getID() + " created";
                    break;

            }
            if (null != output) {
                System.out.println(output);
            }
            input = scan.nextLine();
        }
    }
}
