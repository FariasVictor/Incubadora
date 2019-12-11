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
public class OperationsWithdrawTest {

    @Autowired
    private Operations operations;

    @MockBean
    AccountRepository accountRepository;

    private Account account;
    private OperationRequest operationRequest;

    @Test
    public void valueLessThanBalanceWithdrawTest() {
        account= new Account(200,2000,2000);
        account.setId(1L);
        operationRequest = new OperationRequest(100);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(account));

        operations.withdraw(account.getId(), operationRequest);
        Assertions.assertEquals(100, account.getBalance());
        Assertions.assertEquals(2000, account.getAvailableOverdraft());
    }

    @Test
    public void UnavailableValueWithdrawTest() {
        account= new Account(200,2000,2000);
        account.setId(1L);
        operationRequest = new OperationRequest(100000.00);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.withdraw(account.getId(), operationRequest);
        Assertions.assertEquals(200, account.getBalance());
        Assertions.assertEquals(2000, account.getAvailableOverdraft());

    }

    @Test
    public void valueEqualsBalanceWithdrawTest() {
        account = new Account(500, 550, 600);
        account.setId(1L);
        operationRequest = new OperationRequest(500.00);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.withdraw(account.getId(), operationRequest);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(550, account.getAvailableOverdraft());
    }

    @Test
    public void valueEqualsBalancePlusAvailableOverdraftWithdrawTest() {
        account= new Account(200,2000,2000);
        account.setId(1L);
        operationRequest = new OperationRequest(2200);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.withdraw(account.getId(), operationRequest);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(0, account.getAvailableOverdraft());
    }

    @Test
    public void valueGreaterThanBalanceAndLessThanAvailableOverdraftWithdrawTest() {
        account = new Account(500, 600, 600);
        account.setId(1L);
        operationRequest = new OperationRequest(700.00);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.withdraw(account.getId(), operationRequest);
        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(400, account.getAvailableOverdraft());
    }

    @Test
    public void NegativeValue() {
        account=new Account(0,5000,5000);
        account.setId(1L);
        operationRequest = new OperationRequest(-200);

        Mockito.when(accountRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(account));

        operations.withdraw(account.getId(), operationRequest);

        Assertions.assertEquals(0, account.getBalance());
        Assertions.assertEquals(5000, account.getAvailableOverdraft());
    }
}
