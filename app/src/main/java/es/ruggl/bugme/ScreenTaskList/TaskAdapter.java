package es.ruggl.bugme.ScreenTaskList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import es.ruggl.bugme.Model.Task.Task;
import es.ruggl.bugme.R;

/**
 * Created by ruggles on 9/8/17.
 */

public class TaskAdapter extends BaseAdapter {

    private Task[] taskArray;
    private Context myContext;
    private LayoutInflater myInflater;
    private View.OnClickListener rowListener;
    private View.OnClickListener CBListener;


    public TaskAdapter(Context myContext, Task[] taskArray, View.OnClickListener rowListener, View.OnClickListener CBListener) {
        this.myContext = myContext;
        this.myInflater = (LayoutInflater) myContext.getSystemService(myContext.LAYOUT_INFLATER_SERVICE);
        this.taskArray = taskArray;
        this.rowListener = rowListener;
        this.CBListener = CBListener;
    }

    @Override
    public int getCount() {
        return taskArray.length;
    }

    @Override
    public Object getItem(int position) {
        return taskArray[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    This function returns each individual view that comprises the whole ListView

    So in order...
    Inflate a new view!
    Update view using information from Task
    Attach listeners to specific objects
    Return the new view!

     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I'm going to initially ignore convertView
        Task myTask = taskArray[position];

        // Setting 3rd param to false, unsure what it means to "attach to root"
        boolean attachToRoot = false;
        View taskView = myInflater.inflate(R.layout.task_list_item, parent, attachToRoot);

        TextView titleView = (TextView) taskView.findViewById(R.id.Task_Item_Title);
        titleView.setText(myTask.getTitle());

        TextView dueDateView = (TextView) taskView.findViewById(R.id.Task_Item_Due);
        dueDateView.setText("Due by: " + myTask.getDueDate() + " ");

        CheckBox finishedCB = (CheckBox) taskView.findViewById(R.id.Task_Item_CB);
        finishedCB.setChecked(myTask.isCompleted());

        // Attach our listeners
        taskView.setOnClickListener(rowListener);
        finishedCB.setOnClickListener(CBListener);

        return taskView;
    }
}
