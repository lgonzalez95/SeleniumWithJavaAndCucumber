package com.lg.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

public class ReplacementUtil {
    public static String replaceStringWith(String value) {
        return switch (value) {
            case "<empty>" -> "";
            case "<null>" -> null;
            case "<randomWord>" -> FakerUtility.faker.lorem().word();
            case "<randomSentence>" -> FakerUtility.faker.lorem().sentence();
            case "<UUID>" -> UUID.randomUUID().toString();
            case "<HalfUUID>" -> {
                String uuid = UUID.randomUUID().toString();
                yield uuid.substring(0, uuid.length() / 2);
            }
            default -> value;
        };
    }

    public static int replaceIntWith(String value) {
        if (value.equalsIgnoreCase("<randomInt>"))
            return FakerUtility.faker.random().nextInt(10);
        else return Integer.parseInt(value);
    }
}
