package DAO;

import DAO.AccountDAO;
import domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.*;

import java.util.Optional;

import static Application.Application.*;


public class Operations {
    EntityManager entityManager;
    EntityTransaction transaction;

    public Operations(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction = this.entityManager.getTransaction();
    }

    public void transfer(Account account){
        AccountDAO accountDAO = new AccountDAO(entityManager);
        Optional<Account> accountToTransfer;
        do {
            accountToTransfer = accountDAO.findById(readLong("Digite a conta à qual será feita a transferência: "));
            if(accountToTransfer.isEmpty())
                showMessage("Conta inválida");
        }while(accountToTransfer.isEmpty());
        double value = readDouble("Digite o valor a ser transferido:");
        withdrawTransfer(account,value);



    }

    public void withdraw(Account account) {
        double value = readDouble("Digite o valor a ser sacado:");
        AccountDAO accountDAO = new AccountDAO(entityManager);

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
            showMessage("Limite indisponível");
        }

        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }
    public void withdrawTransfer(Account account, double value) {

        AccountDAO accountDAO = new AccountDAO(entityManager);

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
            showMessage("Limite indisponível");
        }

        account.setAvailableOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void deposit(Account account) {
        double value = readDouble("Digite o valor a ser depositado:");
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
        AccountDAO accountDAO = new AccountDAO(entityManager);
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
        AccountDAO accountDAO = new AccountDAO(entityManager);
        accountDAO.update(account);
    }
    public void statement(Account account){
        AccountDAO accountDAO = new AccountDAO(entityManager);
        showMessage(accountDAO.findById(account.getAccountNumber()).toString());
    }
}
