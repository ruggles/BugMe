package es.ruggl.bugme;

import org.junit.Test;

import java.util.Date;

import es.ruggl.bugme.Model.Task.Task;

import static org.junit.Assert.*;

/**
 * Created by ruggles on 9/4/17.
 */

public class DateParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void DateParser_GivenInvalidDate_ReturnsException() {

        String poorDateTime = "0lkdsjfa";
        Date badDate = DateParser.parse(poorDateTime);

    }

    @Test
    public void DateParser_GivenDateTime_ReturnsSameDate() {

        String dateTimeString = "5/21/17 5:35 PM";
        String dateString = "5/21/17";
        Date dateObject = DateParser.parse(dateTimeString);

        assertEquals(dateString, DateParser.getDate(dateObject));

    }

    @Test
    public void DateParser_GivenDateTime_ReturnsSameDateTime() {

        String dateTimeString = "5/21/17 5:35 PM";
        Date dateObject = DateParser.parse(dateTimeString);

        assertEquals(dateTimeString, DateParser.getDateTime(dateObject));

    }

    @Test
    public void DateParser_GivenDateTime_ReturnsSameTime() {

        String dateTimeString = "5/21/17 5:13 AM";
        String timeString = "5:13 AM";
        Date dateObject = DateParser.parse(dateTimeString);

        assertEquals(timeString, DateParser.getTime(dateObject));

    }

}
