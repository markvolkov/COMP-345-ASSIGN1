package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        bankAccount.withdraw(-100);
        bankAccount.withdraw(100.001);

        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse(BankAccount.isEmailValid( "a@@b.com"));
        assertFalse(BankAccount.isEmailValid("@.@.@"));
        assertFalse(BankAccount.isEmailValid("@.com"));
        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("$.$.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 300);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(300, bankAccount.getBalance());
        //check for exception thrown correctly
        //Invalid Email
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        //Invalid Balance
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("valid@valid.com", -100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("valid@valid.com", 100.001));
    }

}