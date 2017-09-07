package es.ruggl.bugme.Model.Task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ruggles on 9/4/17.
 */

public class Task {

    private final long id;
    private final String title;
    private final String description;
    private final Date createdDate;
    private final Date dueDateTime;
    private final boolean reminder;
    private final boolean completed;

    // If not constructed w/ ID, default ID to 0
    public Task (String title, String description, String dueDateTime, boolean reminder, boolean completed) {
        this(0, title, description, dueDateTime, reminder, completed);
    }

    public Task (long id, String title, String description, String dueDateTime, boolean reminder, boolean completed) {

        this.dueDateTime = dateParse(dueDateTime);

        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = new Date();
        this.reminder = reminder;
        this.completed = completed;


    }

    private Date dateParse(String dateString) {
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

    public String getDueDate() {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(dueDateTime);
    }

    public String getDueTime() {
        return DateFormat.getTimeInstance(DateFormat.SHORT).format(dueDateTime);
    }

    public String getDueDateTime() {
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(dueDateTime);
    }

    public String getCreatedDate() {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(createdDate);
    }

}
