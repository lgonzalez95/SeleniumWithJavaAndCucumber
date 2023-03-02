package com.lg.constants;

public enum Environment {
    DEV("dev"),
    QA("qa"),
    PROD("prod");

    public final String env;

    Environment(String env) {
        this.env = env;
    }
}
