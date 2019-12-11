package com.invillia.Account.service;

import com.invillia.Account.factory.AccountFactory;
import com.invillia.Account.model.Account;
import com.invillia.Account.model.request.OperationRequest;
import com.invillia.Account.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationsDepositTest {

    @Autowired
    private Operations operations;

    @MockBean
    private AccountRepository accountRepository;

    private Account account;

    private OperationRequest operationRequest;


    @Test
    void ValueGreaterThanAccountDebt() {
        operationRequest = new OperationRequest(200);
        account = new Account(0, 100, 200);
        account.setId(1L);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.deposit(account.getId(), operationRequest);

        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(200, account.getAvailableOverdraft());
    }

    @Test
    public void ValueLessThanAccountDebt() {
        account = new Account(0, 100, 200);
        account.setId(1L);
        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));


        operationRequest = new OperationRequest(50);
        operations.deposit(account.getId(), operationRequest);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(150, account.getAvailableOverdraft());
    }

    @Test
    public void ValueEqualsAccountDebt() {
        account = new Account(0, 50, 200);
        account.setId(1L);
        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operationRequest = new OperationRequest(150);
        operations.deposit(account.getId(), operationRequest);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(200, account.getAvailableOverdraft());
    }

    @Test
    public void ZeroAccountDebt() {
        account = new Account(100, 200, 200);
        account.setId(1L);
        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operationRequest = new OperationRequest(200);

        operations.deposit(account.getId(), operationRequest);
        Assertions.assertEquals(300, account.getBalance());
        Assertions.assertEquals(200, account.getAvailableOverdraft());
    }

    @Test
    public void NegativeValue() {
        account = new Account(100, 200, 200);
        account.setId(1L);
        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operationRequest = new OperationRequest(-200);

        operations.deposit(account.getId(), operationRequest);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(200, account.getAvailableOverdraft());
    }

    @Test
    public void ZeroValue() {
        account = new Account(100, 200, 200);
        account.setId(1L);
        operationRequest = new OperationRequest(0);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.deposit(account.getId(), operationRequest);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(200, account.getAvailableOverdraft());
    }
}
