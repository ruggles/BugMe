package es.ruggl.bugme;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ruggl.bugme.Model.Repository.Source.TaskLocalSource;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/23/17.
 */

@RunWith(AndroidJUnit4.class)
public class TaskLocalSourceTest {

    private Context appContext;
    private TaskLocalSource mySource;

    @Before
    public void PretestSetup() {
        appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(TaskLocalSource.DBFILENAME); // Clears state, each test is fresh
        mySource = TaskLocalSource.getInstance(appContext);
    }

    @Test
    public void TaskLocalSource_GivenNoTasks_ReturnsEmptyList() {

    }

    @Test
    public void TaskLocalSource_GivenTasks_ReturnsListOfTasks() {

    }

    @Test
    public void TaskLocalSource_GivenTasks_SuccessfullyDeletesTask() {

    }

    @Test
    public void TaskLocalSource_GivenTasks_SuccessfullyReplacesTask() {

    }

    @Test
    public void TaskLocalSource_GivenDupeAddTask_ThrowsException() {

    }

    @Test
    public void TaskLocalSource_WhenDeletingNonexistentTask_ThrowsException() {

    }

    @Test
    public void TaskLocalSource_WhenReplacingNonexistentTask_ThrowsException() {

    }

    public Task[] initializeWithTasks() {
        Task[] taskArray = new Task[0];

        return taskArray;
    }

}
