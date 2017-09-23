package es.ruggl.bugme.Model.Repository.Source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import es.ruggl.bugme.Model.Repository.DataSource;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/16/17.
 */

public class TaskLocalSource implements DataSource, TaskDBConfig {

    private TaskDBHelper myHelper;
    private SQLiteDatabase myDB;
    private static TaskLocalSource instance;

    public static TaskLocalSource getInstance(Context appContext) {
        if (instance == null) {
            instance = new TaskLocalSource(TaskDBHelper.getInstance(appContext));
        }

        return instance;
    }


    private TaskLocalSource(TaskDBHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void getTasks(GetTasksCallback callback) {
        callback.onTasksLoaded(new Task[0]);
    }

    @Override
    public void addTask(Task newTask) {

    }

    @Override
    public void deleteTask(Task oldTask) {

    }

    @Override
    public void replaceTask(Task oldTask) {

    }
}
