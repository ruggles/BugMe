package es.ruggl.bugme.Model.Repository;

import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/17/17.
 */

public interface DataSource {

    interface GetTasksCallback {
        void onTasksLoaded(Task[] taskArray);
    }

    public void getTasks(GetTasksCallback callback);

    // We're not going to worry about duplicates, as each task will be assigned an ID by the database
    // New tasks will have an ID of zero.
    public void addTask(Task newTask);

    public void deleteTask(Task oldTask);

    public void replaceTask(Task oldTask);

}
