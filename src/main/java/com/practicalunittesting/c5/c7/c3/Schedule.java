package com.practicalunittesting.c5.c7.c3;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private Map<DayOfWeek, boolean[]>  daysHours = new HashMap<>();

    public Schedule() {
        for (DayOfWeek dayOfWeek: DayOfWeek.values()) {
            daysHours.put(dayOfWeek, new boolean[24]);
        }
    }

    public boolean isAvailable(DayOfWeek dayOfWeek, int hour) {
        return !daysHours.get(dayOfWeek)[hour];
    }

    public void book(DayOfWeek dayOfWeek, int hour) {
        daysHours.get(dayOfWeek)[hour] = true;
    }
}
