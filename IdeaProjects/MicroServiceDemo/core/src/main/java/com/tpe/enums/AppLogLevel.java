package com.tpe.enums;

public enum AppLogLevel {

    ERROR("ERROR"),
    WARN("WARN"),
    INFO("INFO");

    private String nameN;

    AppLogLevel(String name) {
        this.nameN = name;
    }

    public String getNameN() {
        return nameN;
    }

    public static AppLogLevel enumFromString(String level) {
        for (AppLogLevel logLevel: AppLogLevel.values()) {
            if (logLevel.nameN.equalsIgnoreCase(level)) {
                return logLevel;
            }
        }
        return null;
    }
}
