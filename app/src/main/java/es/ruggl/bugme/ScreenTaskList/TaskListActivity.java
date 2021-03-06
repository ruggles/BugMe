package es.ruggl.bugme.ScreenTaskList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import es.ruggl.bugme.Model.Repository.Source.DummyDataSource;
import es.ruggl.bugme.Model.Task.Task;
import es.ruggl.bugme.R;
import es.ruggl.bugme.ScreenTaskEdit.TaskEditActivity;

public class TaskListActivity extends AppCompatActivity implements TaskListContract.View {

    private ListView myListView;
    private TaskListContract.Presenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myListView = (ListView) findViewById(R.id.Task_List);

        // Set Presenter
        setPresenter(new TaskListPresenter(this, DummyDataSource.getInstance()));
    }

    private void gotoTaskEdit() {
        Intent myIntent = new Intent(this, TaskEditActivity.class);
        startActivity(myIntent);
    }

    private void completeTask() {
        Toast.makeText(this, "Completed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myPresenter.start();
        myPresenter.loadTasks();
    }

    @Override
    public void setPresenter(TaskListContract.Presenter myPresenter) {
        this.myPresenter = myPresenter;
    }

    @Override
    public void showTasks(Task[] taskArray) {

        // Setup our listeners
        View.OnClickListener rowListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTaskEdit();
            }
        };

        // TODO Make this do anything
        View.OnClickListener CBListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeTask();
            }
        };

        myListView.setAdapter(new TaskAdapter(this, taskArray, rowListener, CBListener));

    }
}
