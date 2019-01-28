package edu.ithaca.dragon.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }

        if (startingBalance >= 0) {
            this.balance = startingBalance;
        } else {
            throw new IllegalArgumentException("Starting balance cannot be negative: " + startingBalance);
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  throws InsufficientFundsException {
        if (amount < 0 || amount > balance) throw new InsufficientFundsException("Insufficient funds.");
        balance -= amount;

    }

    public static boolean isEmailValid(String email) {
        if (email.length() == 0) return false;
        if (email.indexOf('@') == -1) return false;
//        Pattern pattern = Pattern.compile("\\w+@{1}\\w+.\\w+");
//        return pattern.matcher(email).matches();
        return true;
    }
}
