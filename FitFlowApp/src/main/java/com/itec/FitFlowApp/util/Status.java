package com.itec.FitFlowApp.util;

import lombok.Data;


public enum Status {
    STAGNANT("estado estancado"),
    ACTIVE("estado activo"),
    DISABLE("estado inactivo");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
