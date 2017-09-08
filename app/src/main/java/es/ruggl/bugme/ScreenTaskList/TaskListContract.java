package es.ruggl.bugme.ScreenTaskList;

import es.ruggl.bugme.BasePresenter;
import es.ruggl.bugme.BaseView;
import es.ruggl.bugme.Model.Task.Task;

/**
 * Created by ruggles on 9/3/17.
 */

public interface TaskListContract {

    interface View extends BaseView<Presenter> {
        void showTasks(Task[] taskArray);
    }

    interface Presenter extends BasePresenter {
        void loadTasks();
    }
}
