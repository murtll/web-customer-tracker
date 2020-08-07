package com.murtll.springdemo.utils;

public class Utils {
    public static String capitalize(String string) {
        if (string.isEmpty()) return string;
        else return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String addArgsToMethod(String methodInfo, Object[] args) {

        if (args.length > 0) {
            StringBuilder info = new StringBuilder(methodInfo + ", args: (");
            for (Object arg : args) {
                info.append(arg).append(", ");
            }
            info.append("\b\b)");

            return info.toString();
        } else {
            return methodInfo;
        }

    }

}
