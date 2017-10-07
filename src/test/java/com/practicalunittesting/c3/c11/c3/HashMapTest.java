package com.practicalunittesting.c3.c11.c3;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class HashMapTest {

    private HashMap<String, String> hashMap;

    @Before
    public void setUp() {
        hashMap = new HashMap<>();
    }

    @Test
    public void getAfterPutReturnsRightValue() {
        hashMap.put("testKey", "testValue");

        assertEquals("testValue", hashMap.get("testKey"));
    }

    @Test
    public void putWithSameKeyReplacesOldValue() {
        hashMap.put("key", "oldValue");
        hashMap.put("key", "newValue");

        assertFalse(hashMap.containsValue("oldValue"));
        assertEquals("newValue", hashMap.get("key"));
    }

    @Test
    public void clearRemovesAllContent() {
        hashMap.put("key", "value");
        hashMap.clear();

        assertTrue(hashMap.isEmpty());
    }

    @Test
    public void nullCanBeKey() {
        hashMap.put(null, "valueOfNullKey");

        assertEquals("valueOfNullKey", hashMap.get(null));
    }
}
