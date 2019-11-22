package com.invillia.Account.service;

import com.invillia.Account.model.Account;
import com.invillia.Account.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationsDepositTest {
    private Operations operations;
    private AccountRepository accountRepository;
    private Account account;

    @Autowired
    public OperationsDepositTest(Operations operations, AccountRepository accountRepository) {
        this.operations = operations;
        this.accountRepository = accountRepository;
    }

    @Test
    public void ValueGreaterThanAccountDebt() {
        account = new Account(0, 100, 200);
        operations.deposit(account, 200.00);
        Assertions.assertEquals(100, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(200, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void ValueLessThanAccountDebt() {
        account = new Account(0, 100, 200);
        operations.deposit(account, 50.00);
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(150, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void ValueEqualsAccountDebt() {
        account = new Account(0, 50, 200);
        operations.deposit(account, 150.00);
        Assertions.assertEquals(0, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(200, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void ZeroAccountDebt(){
        account = new Account(100, 200, 200);
        operations.deposit(account, 200.00);
        Assertions.assertEquals(300, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(200, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void NegativeValue(){
        account = new Account(100, 200, 200);
        operations.deposit(account, -200.00);
        Assertions.assertEquals(100, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(200, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }

    @Test
    public void ZeroValue(){
        account = new Account(100, 200, 200);
        operations.deposit(account, 0.00);
        Assertions.assertEquals(100, accountRepository.findById(account.getId()).get().getBalance());
        Assertions.assertEquals(200, accountRepository.findById(account.getId()).get().getAvailableOverdraft());
    }
}
