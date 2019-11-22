package com.invillia.Account.model;

import javax.persistence.*;

@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Id
    private long id;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private double availableOverdraft;

    @Column(nullable = false)
    private double maxOverdraft;

    public Account() {

    }

    public Account(double balance, double availableOverdraft, double maxOverdraft) {
        this.balance = balance;
        this.availableOverdraft = availableOverdraft;
        this.maxOverdraft = maxOverdraft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailableOverdraft() {
        return availableOverdraft;
    }

    public void setAvailableOverdraft(double availableOverdraft) {
        this.availableOverdraft = availableOverdraft;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }
}
