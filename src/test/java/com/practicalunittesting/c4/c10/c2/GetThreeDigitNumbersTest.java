package com.practicalunittesting.c4.c10.c2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class GetThreeDigitNumbersTest {

    private static Object[] getParams() {
        return new Object[]{
                new Object[]{null, Collections.EMPTY_LIST},
                new Object[]{"", Collections.EMPTY_LIST},
                new Object[]{"111", Collections.singletonList(111)},
                new Object[]{"000", Collections.singletonList(0)},
                new Object[]{"1111", Collections.EMPTY_LIST},
        };
    }

    @Test
    @Parameters(method = "getParams")
    public void getValidList(String inputString, List<Integer> expectedList) {
        assertEquals(expectedList, StringParser.getThreeDigitNumbers(inputString));
    }
}
