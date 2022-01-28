package org.xpdojo.bank;

public class Account {

    private String accountNumber;

    public int getBalance() {
        return balance;
    }

    private int balance;


    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        int remainingBalance = balance - amount;
        if(remainingBalance < 0){
            throw new RuntimeException();
        }
        balance = remainingBalance;
    }
}
