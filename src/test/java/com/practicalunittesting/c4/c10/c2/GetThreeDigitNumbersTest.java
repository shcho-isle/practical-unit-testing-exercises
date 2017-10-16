package com.practicalunittesting.c4.c10.c2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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
                new Object[]{"000", Collections.singletonList(0)},
                new Object[]{"123", Collections.singletonList(123)},
                new Object[]{"1234", Collections.singletonList(123)},
                new Object[]{"12345", Collections.singletonList(123)},
                new Object[]{"12 345", Collections.singletonList(345)},
                new Object[]{"1 234 5", Collections.singletonList(234)},
                new Object[]{"123456", Arrays.asList(123, 456)},
                new Object[]{"111222333444555666777888", Arrays.asList(111, 222, 333, 444, 555, 666, 777, 888)},
                new Object[]{"asdfa123sdafa sadfasdf456 789sdfsdf", Arrays.asList(123, 456, 789)},
                new Object[]{"12.34_56e78+90", Collections.EMPTY_LIST},
        };
    }

    @Test
    @Parameters(method = "getParams")
    public void getValidList(String inputString, List<Integer> expectedList) {
        assertEquals(expectedList, StringParser.getThreeDigitNumbers(inputString));
    }
}
