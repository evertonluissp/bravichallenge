package com.evertonluissp.wirecardchallenge.utils;

public class StringUtils {

    public static String removeFirstAndLastCharacter(String string) {
        return string.substring(1, string.length() - 1);
    }

}
