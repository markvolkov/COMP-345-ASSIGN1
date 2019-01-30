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

        if (isAmountValid(startingBalance)) {
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
        if (isAmountValid(amount)) throw new IllegalArgumentException("Invalid amount, valid amounts are greater than 0, and have no more than 2 decimal places");
        if (amount < 0 || amount > balance) throw new InsufficientFundsException("Insufficient funds.");
        balance -= amount;

    }

    /***
     * Problems with amounts
     * No money amounts coming in should have more than 2 decimal places. Also should never be negative. We need to check this in multiple places...
     * Write the header and comment for a static method called isAmountValid that takes a double and returns true if the amount is positive and has two decimal points or less, and false otherwise. Make the method always return false for now (Do not even bother to think about how you will write this function).
     * Write tests that check isAmountValid works to specification (some will fail now).
     * git add, commit, push
     * fix the function to meet the specification
     * git add, commit, push
     * Add tests to the constructorTest and the withdrawTest that check that negative and many decimal place numbers can't be given (these tests will fail).
     * git add, commit, push
     * Fix constructor and withdraw to rely on isAmountValid
     * git add, commit, push
     * */


    /**
     * @param amount
     * @return true if the amount is positive and has two decimal points or less, false otherwise
     */
    public static boolean isAmountValid(double amount) {
        return false;
    }

    public static boolean isEmailValid(String email) {
        if (email.length() == 0) return false;
        if (email.indexOf('@') == -1) return false;
        return Pattern.compile("\\w+@{1}\\w+.\\w+").matcher(email).matches();
    }

}
