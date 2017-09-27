package es.ruggl.bugme;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import es.ruggl.bugme.Model.Repository.DataSource;
import es.ruggl.bugme.Model.Repository.Source.TaskLocalSource;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/23/17.
 */

@RunWith(AndroidJUnit4.class)
public class TaskLocalSourceTest {

    private Context appContext;
    private TaskLocalSource mySource;
    private Task[] returnedTasks;

    @Before
    public void PretestSetup() {
        appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(TaskLocalSource.DBFILENAME); // Clears state, each test is fresh
        mySource = TaskLocalSource.getInstance(appContext);
        returnedTasks = null;
    }

    @Test
    public void TaskLocalSource_GivenNoTasks_ReturnsEmptyArray() {
        populateTasks();
        assertArrayEquals(new Task[0], returnedTasks);
    }

    @Test
    public void TaskLocalSource_GivenTasks_ReturnsListOfTasks() {
        Task[] expected = createTaskArray(5);
        initializeWithTasks(expected);
        populateTasks();

        assertArrayEquals(expected, returnedTasks);
    }

    @Test
    public void TaskLocalSource_GivenTasks_SuccessfullyDeletesTask() {
        fail();
    }

    @Test
    public void TaskLocalSource_GivenTasks_SuccessfullyReplacesTask() {
        fail();
    }

    @Test
    public void TaskLocalSource_GivenDupeAddTask_ThrowsException() {
        fail();
    }

    @Test
    public void TaskLocalSource_WhenDeletingNonexistentTask_ThrowsException() {
        fail();
    }

    @Test
    public void TaskLocalSource_WhenReplacingNonexistentTask_ThrowsException() {
        fail();
    }

    public Task[] createTaskArray(int length) {
        Task[] taskArray = new Task[length];

        for (int i=0; i<length; i++)
            taskArray[i] = new Task(i+1, "Title" + i, "Desc" + i, "10/30/2017", false, false);

        return taskArray;
    }

    public void initializeWithTasks(Task[] givenTasks) {
        for (Task task: givenTasks) {
            mySource.addTask(task);
        }
    }

    private void populateTasks() {

        mySource.getTasks(new DataSource.GetTasksCallback() {
            @Override
            public void onTasksLoaded(Task[] taskArray) {
                returnedTasks = taskArray;
            }
        });

    }


}
