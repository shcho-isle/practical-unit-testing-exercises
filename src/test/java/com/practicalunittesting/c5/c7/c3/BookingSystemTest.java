package com.practicalunittesting.c5.c7.c3;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.DayOfWeek;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {

    private BookingSystem bookingSystem;

    private ClassRoom classRoomA = mock(ClassRoom.class);
    private ClassRoom classRoomB = mock(ClassRoom.class);
    private ClassRoom classRoomC = mock(ClassRoom.class);

    @Before
    public void setUp() {
        when(classRoomA.getName()).thenReturn("room A");
        when(classRoomB.getName()).thenReturn("room B");
        when(classRoomC.getName()).thenReturn("room C");

        bookingSystem = new BookingSystem();
        bookingSystem.add(classRoomA);
        bookingSystem.add(classRoomB);
        bookingSystem.add(classRoomC);
    }

    @Test
    public void getAllRoomsTest() {
        Set<ClassRoom> expectedRooms = new HashSet<>();
        expectedRooms.add(classRoomA);
        expectedRooms.add(classRoomB);
        expectedRooms.add(classRoomC);

        Set<ClassRoom> actualRooms = bookingSystem.getAllRooms();

        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    public void getAllRoomsShouldReturnsEmptySet() {
        BookingSystem bs = new BookingSystem();

        assertTrue(bs.getAllRooms().isEmpty());
    }

    @Test
    public void getAvailableRoomsTest() {
        bookingSystem.book("room B", DayOfWeek.MONDAY, 10);

        Set<ClassRoom> expectedRooms = new HashSet<>();
        expectedRooms.add(classRoomA);
        expectedRooms.add(classRoomC);

        Set<ClassRoom> actualRooms = bookingSystem.getAvailableRooms(DayOfWeek.MONDAY, 10);

        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    public void getAvailableRoomsShouldReturnsEmptySet() {
        bookingSystem.book("room A", DayOfWeek.MONDAY, 10);
        bookingSystem.book("room B", DayOfWeek.MONDAY, 10);
        bookingSystem.book("room C", DayOfWeek.MONDAY, 10);

        Set<ClassRoom> actualRooms = bookingSystem.getAvailableRooms(DayOfWeek.MONDAY, 10);

        assertTrue(actualRooms.isEmpty());
    }

    @Test
    public void bookByNameTest() {

    }


//    @Test
//    public void getBookedHoursTest() {
//        assertEquals(Arrays.asList(5, 17, 18, 19, 20), bookingSystem.getBookedHours());
//    }
//
//    @Test
//    public void doubleBookedNotAllowTest() {
//        assertEquals(-1, bookingSystem.book(18));
//        assertEquals(-1, bookingSystem.book(4, 5));
//        assertEquals(-1, bookingSystem.book(20, 21));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters({"-1", "-5", "24", "100"})
//    public void illegalValuesTest1(int hour) {
//        bookingSystem.book(hour);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    @Parameters({"-9, -5", "-9, 0", "5, 5", "18, 15", "14, -15", "247, 19", "9, 29", "34, 47", "23, 27"})
//    public void illegalValuesTest2(int fromHour, int toHour) {
//        bookingSystem.book(fromHour, toHour);
//    }
}
