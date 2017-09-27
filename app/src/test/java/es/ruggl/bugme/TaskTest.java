package es.ruggl.bugme;

import org.junit.Before;
import org.junit.Test;

import es.ruggl.bugme.Model.Task.Task;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TaskTest {

    private static Task[] taskArray ;

    @Before
    public void beforeTest() {
        taskArray = new Task[] {new Task(1, "title", "dub", "05/21/2017", true, false),
                    new Task(2, "title2", "dumb", "05/24/2017", false, true)};
    }

    @Test
    public void Task_Equals_Symmetry() {
        for (Task task: taskArray) {
            assertTrue(task.equals(task));
        }
    }

    @Test
    public void Nonequal_Tasks_ReturnFalse() {
        assertFalse(taskArray[0].equals(taskArray[1]));
    }


}