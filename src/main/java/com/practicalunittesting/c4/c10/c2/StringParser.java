package com.practicalunittesting.c4.c10.c2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public static List<Integer> getThreeDigitNumbers(String string) {
        if (string == null || string.length() == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Matcher matcher= Pattern.compile("\\d{3}").matcher(string);
        while (matcher.find()) {
            result.add(Integer.parseInt(matcher.group()));
        }

        return result;
    }
}
