package es.ruggl.bugme.Model.Task;

import java.util.Date;

import es.ruggl.bugme.DateParser;

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

    // If not constructed w/ ID, default ID to 0 - these are new tasks
    public Task (String title, String description, String dueDateTime, boolean reminder, boolean completed) {
        this(0, title, description, dueDateTime, reminder, completed);
    }

    public Task (long id, String title, String description, String dueDateTime, boolean reminder, boolean completed) {

        this.dueDateTime = DateParser.parse(dueDateTime);

        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = new Date();
        this.reminder = reminder;
        this.completed = completed;


    }

    // TODO All these damn getters, this is definitely a smell

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isReminderSet() {
        return this.reminder;
    }

    public String getDueDate() {
        return DateParser.getDate(dueDateTime);
    }

    public String getDueTime() {
        return DateParser.getTime(dueDateTime);
    }

    public String getDueDateTime() {
        return DateParser.getDateTime(dueDateTime);
    }

    public String getCreatedDate() {
        return DateParser.getDate(createdDate);
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;

        // Run through all the variables

        if ((this.getTitle().equals(otherTask.getTitle()))
                &&
                (this.getDescription().equals(otherTask.getDescription()))
                &&
                (this.getDueDateTime().equals(otherTask.getDueDateTime()))
                &&
                (this.getCreatedDate().equals(otherTask.getCreatedDate()))
                &&
                (this.getId()==otherTask.getId())
                &&
                (this.isReminderSet()==otherTask.isReminderSet())
                &&
                (this.isCompleted()==otherTask.isCompleted())) {
            return true;
        }

        return false;
    }

}
