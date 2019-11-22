package com.invillia.Account.service;

import com.invillia.Account.exception.InsufficientBalanceException;
import com.invillia.Account.model.Account;
import com.invillia.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Operations {

    private AccountRepository accountRepository;

    @Autowired
    public Operations(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdraw(Account account, Double value) {

        double balance = account.getBalance();
        double availableOverdraft = account.getAvailableOverdraft();


        if (value <= balance + availableOverdraft && value > 0) {
            if (value > balance) {
                availableOverdraft = (balance + availableOverdraft) - value;
                balance = 0;
            } else {
                balance -= value;
            }
        }
        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountRepository.save(account);
    }

    public void deposit(Account account, Double value) {
        double maxOverdraft = account.getMaxOverdraft();
        double availableOverdraft = account.getAvailableOverdraft();
        double balance = account.getBalance();

        double accountDebt = maxOverdraft - availableOverdraft;
        if (value > 0) {
            if (value >= accountDebt) {
                availableOverdraft = maxOverdraft;
                value -= accountDebt;
                balance += value;
            } else {
                availableOverdraft += value;
            }
        }
        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountRepository.save(account);
    }
}
