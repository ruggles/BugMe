package es.ruggl.bugme;

import org.junit.Test;

import es.ruggl.bugme.Model.Task.Task;

import static org.junit.Assert.*;

/**
 * Created by ruggles on 9/4/17.
 */

public class TaskTest {

    @Test(expected = IllegalArgumentException.class)
    public void Task_GiveInvalidDate_ReturnsException() {
        String poorDateTime = "0lkdsjfa";
        Task myTask = createTaskWithDueDateTime(poorDateTime);
    }

    @Test
    public void Task_GivenDueDateTime_ReturnsSameDate() {

        String myDateTime = "5/21/17";
        String myDate = "5/21/17";

        Task newTask = createTaskWithDueDateTime(myDateTime);
        assertEquals(myDate, newTask.getDueDate());

    }

    @Test
    public void Task_GivenDueDateTime_ReturnsSameDateTime() {

        String myDateTime = "5/21/17 5:13 AM";
        Task newTask = createTaskWithDueDateTime(myDateTime);
        assertEquals(myDateTime, newTask.getDueDateTime());
    }

    @Test
    public void Task_GivenDueDateTime_ReturnsSameTime() {

        String myDateTime = "5/21/17 5:13 AM";
        String myTime = "5:13 AM";
        Task newTask = createTaskWithDueDateTime(myDateTime);
        assertEquals(myTime, newTask.getDueTime());
    }

    private Task createTaskWithDueDateTime(String date) {
        return new Task("Title", "Description", date, false, false);
    }

}
