package es.ruggl.bugme.Model.Repository;

import java.util.Arrays;
import java.util.Date;

import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/4/17.
 */

public class TaskRepository {

    static TaskRepository instance;

    Task[] testTasks = { new Task(1, "Title 1", "Description 1", "05/21/2017", true, false),
            new Task(2, "Title 2", "Description 2", "05/21/2017", false, true),
            new Task(3, "Title 3", "Description 3", "05/21/2017", true, true)};

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }

        return instance;
    }

    private TaskRepository() {
    }

    public Task[] getTasks(){

        return testTasks;
    }

    public void addTask(Task newTask) {
        //Sends tasks to DB or other repo

        Task[] newTestTasks = Arrays.copyOf(testTasks, testTasks.length+1);

        newTestTasks[testTasks.length] = newTask;
        testTasks = newTestTasks;
    }


}
