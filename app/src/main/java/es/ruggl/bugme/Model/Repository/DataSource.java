package es.ruggl.bugme.Model.Repository;

import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/17/17.
 */

public interface DataSource {

    public Task[] getTasks();

    public void addTask(Task newTask);

}
