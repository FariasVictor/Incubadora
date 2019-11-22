package com.invillia.Account.model.response;

public class AccountResponse {
    private long id;

    private double balance;

    private double availableOverdraft;

    private double maxOverdraft;

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
