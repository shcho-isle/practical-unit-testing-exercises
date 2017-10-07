package com.practicalunittesting.c3.c11.c2;

public class StringUtils {

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
