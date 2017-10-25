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
public class GetNumbersListTest {

    private static Object[] getParams() {
        return new Object[]{
                new Object[]{null, Collections.EMPTY_LIST},
                new Object[]{"", Collections.EMPTY_LIST},
                new Object[]{"000", Collections.singletonList(0)},
                new Object[]{"123", Collections.singletonList(123)},
                new Object[]{"-12 345", Collections.singletonList(345)},
                new Object[]{"1-234 5", Collections.singletonList(-234)},
                new Object[]{"123456", Collections.singletonList(123456)},
                new Object[]{"2147483647", Collections.singletonList(2147483647)},
                new Object[]{"-2147483648", Collections.singletonList(-2147483648)},
                new Object[]{"asdfa123sdafa sadfasdf456 789sdfsdf", Arrays.asList(123, 456, 789)},
                new Object[]{"12.34_56e78+90", Collections.EMPTY_LIST},
                new Object[]{"abc 12", Collections.EMPTY_LIST},
                new Object[]{"cdefg 345 12bb23", Collections.singletonList(345)},
                new Object[]{"cdefg 345 12bbb33 678tt", Arrays.asList(345, 678)},
        };
    }

    @Test
    @Parameters(method = "getParams")
    public void getValidList(String inputString, List<Integer> expectedList) {
        assertEquals(expectedList, StringParser.getNumbersList(inputString));
    }
}
