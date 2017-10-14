package com.practicalunittesting.c4.c10.c1;

public class PasswordUtils {
    private final static int MIN_PASS_LENGTH = 8;
    private final static String AT_LEAST_ONE_DIGIT_PATTERN = ".*\\d+.*";
    private final static String AT_LEAST_ONE_LOWER_CASE_PATTERN = ".*[a-z]+.*";
    private final static String AT_LEAST_ONE_UPPER_CASE_PATTERN = ".*[A-Z]+.*";
    private final static String UNDERSCORE = "_";

    public static boolean isValid(String password) {
        return password != null
                && password.length() >= MIN_PASS_LENGTH
                && password.matches(AT_LEAST_ONE_DIGIT_PATTERN)
                && password.contains(UNDERSCORE)
                && password.matches(AT_LEAST_ONE_LOWER_CASE_PATTERN)
                && password.matches(AT_LEAST_ONE_UPPER_CASE_PATTERN);
    }
}
