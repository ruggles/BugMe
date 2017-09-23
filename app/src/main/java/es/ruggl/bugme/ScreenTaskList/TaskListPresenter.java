package es.ruggl.bugme.ScreenTaskList;

import es.ruggl.bugme.Model.Repository.DataSource;

/**
 * Created by ruggles on 9/1/17.
 */

public class TaskListPresenter implements TaskListContract.Presenter {

    private TaskListContract.View view;
    private DataSource dataSource;

    public TaskListPresenter(TaskListContract.View view, DataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;
    }

    @Override
    public void loadTasks() {
        view.showTasks(dataSource.getTasks());
    }

    @Override
    public void start() {
        //TODO IMPLEMENT!
    }
}
