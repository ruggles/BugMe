package es.ruggl.bugme;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by ruggles on 9/12/17.
 */

public class DateParser {

    public static Date parse(String dateString) {
        try {
            // First try to parse full format
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).parse(dateString);
        } catch (ParseException e) {
            try {
                // Then try to parse short format
                return DateFormat.getDateInstance(DateFormat.SHORT).parse(dateString);
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Unable to parse date");
            }

        }
    }

    public static String getDate(Date taskDate) {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(taskDate);
    }

    public static String getTime(Date taskDate) {
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(taskDate);
    }

    public static String getDateTime(Date taskDate) {
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(taskDate);
    }
}
