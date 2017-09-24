package es.ruggl.bugme.Model.Repository.Source;

import java.util.Arrays;

import es.ruggl.bugme.Model.Repository.DataSource;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/4/17.
 */

public class DummyDataSource implements DataSource {

    static DummyDataSource instance;

    Task[] testTasks = { new Task(1, "Title 1", "Description 1", "05/21/2017", true, false),
            new Task(2, "Title 2", "Description 2", "05/21/2017", false, true),
            new Task(3, "Title 3", "Description 3", "05/21/2017", true, true)};

    public static DummyDataSource getInstance() {
        if (instance == null) {
            instance = new DummyDataSource();
        }

        return instance;
    }

    private DummyDataSource() {
    }

    @Override
    public void getTasks(GetTasksCallback callback){

        callback.onTasksLoaded(testTasks);
    }

    @Override
    public void addTask(Task newTask) {
        //Sends tasks to DB or other repo

        Task[] newTestTasks = Arrays.copyOf(testTasks, testTasks.length+1);

        newTestTasks[testTasks.length] = newTask;
        testTasks = newTestTasks;
    }

    @Override
    public void deleteTask(Task oldTask) {

    }

    public void replaceTask(Task oldTask) {

    }


}
