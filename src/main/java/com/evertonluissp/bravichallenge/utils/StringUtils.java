package com.evertonluissp.bravichallenge.utils;

public class StringUtils {

    public static String removeFirstAndLastCharacter(String string) {
        return string.substring(1, string.length() - 1);
    }

    public static String removeAllSignals(String string) {
        return string.replaceAll("[^0-9]", "");
    }

}
