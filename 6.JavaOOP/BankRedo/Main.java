package BankRedo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> vault = new HashMap<>();

        String input;
        while (!(input = scan.nextLine()).equals("End")) {

            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String output = "";



            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getID(), bankAccount);
                    output = "Account ID" + bankAccount.getID() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)) {
                        vault.get(id).deposit(amount);
                        output = "Deposited " + amount + " to ID" + id;
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)) {
                        double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    } else {
                        output = "Account does not exist";
                    }

                    break;
            }
            if (output != (null)) {
                System.out.println(output);
            }
        }
    }
    public boolean elementPresent (Map<Integer, BankAccount> vault, int id) {
        boolean isPresent = false;

        if(vault.containsKey(id)) {
            isPresent = true;
        }
        return isPresent;

    }

}
