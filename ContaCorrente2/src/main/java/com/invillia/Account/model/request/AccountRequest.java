package com.invillia.Account.model.request;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class AccountRequest {

    @NotNull
    @Positive
    private double balance;

    @NotNull
    @Positive
    @DecimalMin("300")
    private double maxOverdraft;

    public AccountRequest(@NotNull double balance, @NotNull double maxOverdraft) {
        this.balance = balance;
        this.maxOverdraft = maxOverdraft;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }
}
