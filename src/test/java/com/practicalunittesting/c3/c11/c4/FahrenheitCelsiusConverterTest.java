package com.practicalunittesting.c3.c11.c4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusConverterTest {

    @Test
    @Parameters({"32, 0", "100, 37", "212, 100"})
    public void shouldConvertCelsiusToFahrenheit(int fahrenheit, int celsius) {
        assertEquals(fahrenheit, FahrenheitCelsiusConverter.toFahrenheit(celsius));
    }

    @Test
    @Parameters({"0, 32", "37, 100", "100, 212"})
    public void shouldConvertFahrenheitToCelsius(int celsius, int fahrenheit) {
        assertEquals(celsius, FahrenheitCelsiusConverter.toCelsius(fahrenheit));
    }


}
