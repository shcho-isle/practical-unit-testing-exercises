package com.practicalunittesting.c4.c10.c1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IsValidTest {

    private final static String PASSWORD_TOO_SHORT = "1_3_5_7";
    private final static String PASSWORD_WITHOUT_DIGIT = "Cb__Gku_G";
    private final static String PASSWORD_WITHOUT_UNDERSCORE = "Cb58Gku8G";
    private final static String PASSWORD_WITHOUT_LOWER_CASE = "CB58GKU_G";
    private final static String PASSWORD_WITHOUT_UPPER_CASE = "cb58gku_g";

    private final static String PASSWORD_VALID1 = "Cb58Gku_G";
    private final static String PASSWORD_VALID2 = "__C_b_5_";

    private static Object[] getPassword() {
        return new Object[]{
                new Object[]{PASSWORD_TOO_SHORT, false},
                new Object[]{null, false},
                new Object[]{PASSWORD_WITHOUT_DIGIT, false},
                new Object[]{PASSWORD_WITHOUT_UNDERSCORE, false},
                new Object[]{PASSWORD_WITHOUT_LOWER_CASE, false},
                new Object[]{PASSWORD_WITHOUT_UPPER_CASE, false},
                new Object[]{PASSWORD_VALID1, true},
                new Object[]{PASSWORD_VALID2, true},
        };
    }

    @Test
    @Parameters(method = "getPassword")
    public void isValidTest(String password, boolean valid) {
        assertEquals("expected \"" + valid + "\" for \"" + password + "\" password, " +
                        "but actual is \"" + !valid + "\"",
                valid, PasswordUtils.isValid(password));
    }
}
