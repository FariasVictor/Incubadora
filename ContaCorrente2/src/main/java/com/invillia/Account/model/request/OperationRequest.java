package com.invillia.Account.model.request;

import javax.validation.constraints.*;

public class OperationRequest {


    @NotNull
    @DecimalMin("2")
    private double value;

    public OperationRequest() {
    }

    public OperationRequest(@NotNull double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
