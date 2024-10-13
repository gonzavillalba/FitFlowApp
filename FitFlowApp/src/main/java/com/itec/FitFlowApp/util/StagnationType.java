package com.itec.FitFlowApp.util;

public enum StagnationType {
    PHYSICAL("estancamiento fisico"),
    NUTRITIONAL("estancamiento nutricional");

    private final String type;

    StagnationType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return type;
    }
}
