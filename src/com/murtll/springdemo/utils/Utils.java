package com.murtll.springdemo.utils;

public class Utils {
    public static String capitalize(String string) {
        if (string.isEmpty()) return string;
        else return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
