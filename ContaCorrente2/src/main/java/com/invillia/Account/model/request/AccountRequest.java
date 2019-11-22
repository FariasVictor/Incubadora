package com.invillia.Account.model.request;


import javax.validation.constraints.NotNull;

public class AccountRequest {

    @NotNull
    private double balance;

    @NotNull
    private double availableOverdraft;

    @NotNull
    private double maxOverdraft;

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
