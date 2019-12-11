package com.invillia.Account.model.request;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class UpdateLimitRequest {

    @NotNull
    @DecimalMin("300")
    private double maxOverdraft;

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }
}
