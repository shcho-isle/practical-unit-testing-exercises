package com.practicalunittesting.c3.c11.c1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTest {
    @Test
    public void someAssertions() {
        assertSame(5, "12345".length());
        assertEquals("qwe", "123qwe456".substring(3, 6));
    }
}
