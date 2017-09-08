package es.ruggl.bugme.ScreenTaskList;

import es.ruggl.bugme.Model.Repository.TaskRepository;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/1/17.
 */

public class TaskListPresenter implements TaskListContract.Presenter {

    TaskListContract.View myView;
    TaskRepository myTaskRepository;

    public TaskListPresenter(TaskListContract.View myView) {
        this.myView = myView;
        myTaskRepository = TaskRepository.getInstance();
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
