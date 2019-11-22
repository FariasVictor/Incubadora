package com.invillia.Account.service;

import com.invillia.Account.factory.AccountFactory;
import com.invillia.Account.model.Account;
import com.invillia.Account.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationsWithdrawTest {
    private Operations operations;
    private AccountRepository accountRepository;
    private Account account;

    @Autowired
    public OperationsWithdrawTest(Operations operations, AccountFactory accountFactory, AccountRepository accountRepository) {
        this.operations = operations;
        this.accountRepository = accountRepository;
    }

    @BeforeEach
    public void CreateAccount(){
        account = new Account(500, 550, 600);
    }

    @Test
    public void valueLessThanBalanceWithdrawTest() {
        operations.withdraw(account, 400.00);
        Assertions.assertEquals(100, accountRepository.findById(account.getId()).get().getBalance());
    }

    @Test
    public void UnavailableValueWithdrawTest() {

        operations.withdraw(account, 100000.00);
        Assertions.assertEquals(500, accountRepository.findById(account.getId()).get().getBalance());
    }
    @Test
    public void valueEqualsBalanceWithdrawTest(){
        Account account = new Account(500, 550, 600);
        operations.withdraw(account, 500.00);
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(550, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }
    @Test
    public void valueEqualsBalancePlusAvailableOverdraftWithdrawTest(){
        operations.withdraw(account, 1050.00);
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }
    @Test
    public void valueGreaterThanBalanceAndLessThanAvailableOverdraftWithdrawTest(){
        Account account = new Account(500, 550, 600);
        operations.withdraw(account, 700.00);
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(350, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void NegativeValue(){
        operations.withdraw(account, 0.00);
        Assertions.assertEquals(500, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(550, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }
}
