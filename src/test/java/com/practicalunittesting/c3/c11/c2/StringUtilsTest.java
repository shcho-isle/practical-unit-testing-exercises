package com.practicalunittesting.c3.c11.c2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

    private static Object[] getStrings() {
        return new Object[]{
                new Object[] {"qwe", "ewq"},
                new Object[] {"a", "a"},
                new Object[] {"", ""},
        };
    }

    @Test
    @Parameters(method = "getStrings")
    public void reverseTest(String expected, String s) {
        assertEquals(expected, StringUtils.reverse(s));
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfNull() {
        StringUtils.reverse(null);
    }
}
