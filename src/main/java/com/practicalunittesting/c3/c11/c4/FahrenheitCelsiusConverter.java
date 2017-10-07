package com.practicalunittesting.c3.c11.c4;

public class FahrenheitCelsiusConverter {

    public static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8 + 32);
    }

    public static int toCelsius(int fahrenheit) {
        return (int) ((fahrenheit - 32) / 1.8);
    }
}
