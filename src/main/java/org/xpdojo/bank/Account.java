package org.xpdojo.bank;

public class Account {

    private String accountNumber;
    private int balance;


    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
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
