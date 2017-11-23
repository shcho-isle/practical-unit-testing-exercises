package com.practicalunittesting.c4.c10.c3;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
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
}
