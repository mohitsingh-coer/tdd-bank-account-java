package org.xpdojo.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    Map<String, Account> accountMap = new HashMap<String, Account>();

    @BeforeEach
    public void setup(){
        accountMap = new HashMap<>();
    }

    @Test
    public void deposit() {
        givenAnAccount("ABC");
        whenDepositIsMade("ABC", 10);
        verifyBalanceAccountIs("ABC", 10);
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {
        givenAnAccountWithBalance("ABC", 100);
        whenWithdrawlIsDone("ABC", 90);
        verifyBalanceAccountIs("ABC", 10);
    }

    @Test
    public void withdrawAnAmountThrowsErrorForNegativeBalance() {
        assertThatThrownBy(() -> {
            givenAnAccount("ABC");
            whenDepositIsMade("ABC", 80);
            whenWithdrawlIsDone("ABC", 90);
            verifyBalanceAccountIs("ABC", 10);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void transferBetweenAccounts() {
        givenAnAccountWithBalance("ABC", 100);
        givenAnAccountWithBalance("DEF", 20);
        whenTransferIsDone("ABC", "DEF", 70);
        verifyBalanceAccountIs("ABC", 30);
        verifyBalanceAccountIs("DEF", 90);
    }

    private void whenTransferIsDone(String debitAccount, String creditAccount, int amount) {
        Accountant.transfer(accountMap.get(debitAccount), accountMap.get(creditAccount), amount);
    }


    private void givenAnAccountWithBalance(String accountNumber, int initialBalance) {
        givenAnAccount(accountNumber);
        whenDepositIsMade(accountNumber, initialBalance);
    }

    private void whenWithdrawlIsDone(String accountNumber, int amount) {
        accountMap.get(accountNumber)
                .withdraw(amount);
    }

    private void verifyBalanceAccountIs(String accountNumber, int balance) {
        assertThat(accountMap.get(accountNumber).getBalance()).isEqualTo(balance);
    }

    private void whenDepositIsMade(String accountNumber, int amount) {
        accountMap.get(accountNumber).deposit(amount);
    }

    private void givenAnAccount(String accountNumber) {
        accountMap.put(accountNumber, new Account(accountNumber));
    }
}
