package com.lg.utils;

public class ReplacementUtil {
    public static String replaceStringWith(String value) {
        return switch (value) {
            case "<empty>" -> "";
            case "<null>" -> null;
            case "<randomWord>" -> FakerUtility.faker.lorem().word();
            case "<randomSentence>" -> FakerUtility.faker.lorem().sentence();
            default -> value;
        };
    }

    public static int replaceIntWith(String value) {
        if (value.equalsIgnoreCase("<randomInt>"))
            return FakerUtility.faker.random().nextInt(10);
        else return Integer.parseInt(value);
    }
}
