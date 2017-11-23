package com.practicalunittesting.c4.c10.c3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @Before
    public void setUp() {
        bookingSystem = new BookingSystem();
        bookingSystem.book(5);
        bookingSystem.book(17, 20);
    }

    @Test
    public void getBookedHoursTest() {
        assertEquals(Arrays.asList(5, 17, 18, 19, 20), bookingSystem.getBookedHours());
    }

    @Test
    public void doubleBookedNotAllowTest() {
        assertEquals(-1, bookingSystem.book(18));
        assertEquals(-1, bookingSystem.book(4, 5));
        assertEquals(-1, bookingSystem.book(20, 21));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1", "-5", "24", "100"})
    public void illegalValuesTest1(int hour) {
        bookingSystem.book(hour);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-9, -5", "-9, 0", "5, 5", "18, 15", "14, -15", "247, 19", "9, 29", "34, 47", "23, 27"})
    public void illegalValuesTest2(int fromHour, int toHour) {
        bookingSystem.book(fromHour, toHour);
    }
}
