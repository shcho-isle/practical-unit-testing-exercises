package com.practicalunittesting.c5.c7.c3;

import java.time.DayOfWeek;
import java.util.*;

public class BookingSystem {
    private Map<ClassRoom, Schedule> rooms = new HashMap<>();
    private boolean[] bookedHours = new boolean[24];

    public List<Integer> getBookedHours() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            if (bookedHours[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public int book(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException();
        }

        if (bookedHours[hour]) {
            return -1;
        }

        bookedHours[hour] = true;
        return 1;
    }

    public int book(int fromHour, int toHour) {
        if (fromHour >= toHour || toHour > 24 || fromHour < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = fromHour; i <= toHour; i++) {
            if (bookedHours[i]) {
                return -1;
            } else {
                bookedHours[i] = true;
            }
        }

        return 1;
    }

    public void add(ClassRoom classRoom) {
        if (!rooms.containsKey(classRoom)) {
            rooms.put(classRoom, new Schedule());
        } else {
            throw new IllegalArgumentException(classRoom + " - room already exists.");
        }
    }

    public Set<ClassRoom> getAllRooms() {
        return rooms.keySet();
    }

    public Set<ClassRoom> getAvailableRooms(DayOfWeek dayOfWeek, int hour) {
        Set<ClassRoom> result = new HashSet<>();

        for (Map.Entry<ClassRoom, Schedule> entry: rooms.entrySet()) {
            if (entry.getValue().isAvailable(dayOfWeek, hour)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public void book(String s, DayOfWeek dayOfWeek, int hour) {
        for (Map.Entry<ClassRoom, Schedule> entry: rooms.entrySet()) {
            if (entry.getKey().getName().equals(s)) {
                entry.getValue().book(dayOfWeek, hour);
            }
        }
    }
}
