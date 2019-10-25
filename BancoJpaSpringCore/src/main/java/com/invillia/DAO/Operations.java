package com.invillia.DAO;

import com.invillia.Application;
import com.invillia.domain.Account;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.Optional;

@Service
public class Operations {
    EntityManager entityManager;
    EntityTransaction transaction;
    AccountDAO accountDAO;
    public Operations(EntityManager entityManager, AccountDAO accountDAO) {
        this.entityManager = entityManager;
        this.transaction = this.entityManager.getTransaction();
        this.accountDAO=accountDAO;
    }

    public void transfer(Account account) {
        Optional<Account> accountToTransfer;
        do {
            accountToTransfer = accountDAO.findById(Application.readLong("Digite a conta à qual será feita a transferência: "));
            if (accountToTransfer.isEmpty())
                Application.showMessage("Conta inválida");
        } while (accountToTransfer.isEmpty());
        double value = Application.readDouble("Digite o valor a ser transferido:");
        withdrawTransfer(account, value);
    }

    public void withdraw(Account account) {
        double value = Application.readDouble("Digite o valor a ser sacado:");

        double balance = account.getBalance();
        double availableOverdraft = account.getAvailableOverdraft();

        if (value <= balance + availableOverdraft) {
            if (value > balance) {
                availableOverdraft = (balance + availableOverdraft) - value;
                balance = 0;
            } else {
                balance -= value;
            }
        } else {
            Application.showMessage("Limite indisponível");
        }

        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void withdrawTransfer(Account account, double value) {


        double balance = account.getBalance();
        double availableOverdraft = account.getAvailableOverdraft();

        if (value <= balance + availableOverdraft) {
            depositTransfer(account, value);
            if (value > balance) {
                availableOverdraft = (balance + availableOverdraft) - value;
                balance = 0;
            } else {
                balance -= value;
            }
        } else {
            Application.showMessage("Limite indisponível");
        }

        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void deposit(Account account) {
        double value = Application.readDouble("Digite o valor a ser depositado:");
        double maxOverdraft = account.getMaxOverdraft();
        double availableOverdraft = account.getAvailableOverdraft();
        double balance = account.getBalance();

        double accountDebt = maxOverdraft - availableOverdraft;

        if (value >= accountDebt) {
            availableOverdraft = maxOverdraft;
            value -= accountDebt;
            balance += value;
        } else {
            availableOverdraft += value;
        }
        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void depositTransfer(Account account, double value) {
        double maxOverdraft = account.getMaxOverdraft();
        double availableOverdraft = account.getAvailableOverdraft();
        double balance = account.getBalance();

        double accountDebt = maxOverdraft - availableOverdraft;

        if (value >= accountDebt) {
            availableOverdraft = maxOverdraft;
            value -= accountDebt;
            balance += value;
        } else {
            availableOverdraft += value;
        }
        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void statement(Account account) {
        Application.showMessage(accountDAO.findById(account.getAccountNumber()).toString());
    }
}
