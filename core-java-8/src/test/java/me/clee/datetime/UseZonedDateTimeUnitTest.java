package me.clee.datetime;

import me.clee.datetime.UseZonedDateTime;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UseZonedDateTimeUnitTest {

    UseZonedDateTime zonedDateTime = new UseZonedDateTime();

    @Test
    public void givenZoneId_thenZonedDateTime() {
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDatetime = zonedDateTime.getZonedDateTime(LocalDateTime.parse("2016-05-20T06:30"), zoneId);
        Assert.assertEquals(zoneId, ZoneId.from(zonedDatetime));
    }
}
