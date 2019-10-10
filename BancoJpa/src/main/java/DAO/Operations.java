package DAO;

import domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Operations {
    EntityManager entityManager;
    EntityTransaction transaction;

    public Operations(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction=this.entityManager.getTransaction();
    }

    public void withdraw(Account account, double value){
        AccountDAO accountDAO=new AccountDAO(entityManager);

        double balance = account.getBalance();
        double availableOverdraft = account.getOverdraft();
        if(value<=balance+availableOverdraft) {
            if(value>balance) {
//               value-=balance;
//               availableOverdraft-=value;
                 availableOverdraft=(balance+availableOverdraft)-value;
                balance=0;
            }else{
                balance-=value;
            }
        }else{
            System.out.println("Limite indisponível");
        }

        account.setOverdraft(availableOverdraft);
        account.setBalance(balance);
        accountDAO.update(account);
    }

    public void deposit(Account account, double value){

    }
}
