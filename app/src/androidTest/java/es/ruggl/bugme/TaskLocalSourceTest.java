package es.ruggl.bugme;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ruggl.bugme.Model.Repository.Source.TaskLocalSource;

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

    public void initializeWithTasks() {

    }

}
