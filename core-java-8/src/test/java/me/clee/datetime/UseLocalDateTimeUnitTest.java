package me.clee.datetime;

import me.clee.datetime.UseLocalDateTime;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class UseLocalDateTimeUnitTest {

    UseLocalDateTime useLocalDateTime = new UseLocalDateTime();

    @Test
    public void givenString_whenUsingParse_thenLocalDateTime() {
        assertEquals(LocalDate.of(2018, Month.MAY, 10), useLocalDateTime.getLocalDateTimeUsingParseMethod("2018-05-10T06:30")
            .toLocalDate());
        assertEquals(LocalTime.of(6, 30), useLocalDateTime.getLocalDateTimeUsingParseMethod("2016-05-10T06:30")
            .toLocalTime());
    }
}
