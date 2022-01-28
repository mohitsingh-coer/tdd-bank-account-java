package org.xpdojo.bank;

public class Accountant {

    public static void transfer(Account debitAccount, Account creditAccount, int amount) {
        debitAccount.withdraw(amount);
        creditAccount.deposit(amount);

    }
}
