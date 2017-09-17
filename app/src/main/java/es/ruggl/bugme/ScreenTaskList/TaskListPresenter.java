package es.ruggl.bugme.ScreenTaskList;

import es.ruggl.bugme.Model.Repository.DataSource;
import es.ruggl.bugme.Model.Repository.Source.DummyDataSource;

/**
 * Created by ruggles on 9/1/17.
 */

public class TaskListPresenter implements TaskListContract.Presenter {

    private TaskListContract.View myView;
    private DataSource myTaskRepository;

    public TaskListPresenter(TaskListContract.View myView) {
        this.myView = myView;
        myTaskRepository = DummyDataSource.getInstance();
    }

    @Override
    public void loadTasks() {
        myView.showTasks(myTaskRepository.getTasks());
    }

    @Override
    public void start() {
        //TODO IMPLEMENT!
    }
}
