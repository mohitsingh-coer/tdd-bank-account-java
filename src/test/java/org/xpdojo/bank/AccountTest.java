package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    Map<String, Account> accountMap = new HashMap<String, Account>();

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        givenAnAccount("ABC");
        whenDepositIsMade("ABC", 10);
        verifyBalanceAccountIs("ABC",10);
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
