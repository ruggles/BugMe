package es.ruggl.bugme.ScreenTaskList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import es.ruggl.bugme.R;
import es.ruggl.bugme.ScreenTaskEdit.TaskEditActivity;

public class TaskListActivity extends AppCompatActivity {

    private ListView myListView;

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

        // TODO - FILL IN REAL ADAPTER ONCE WE HAVE A FINISHED MODEL
        myListView = (ListView) findViewById(R.id.Task_List);
        setDummyAdapter();
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoTaskEdit();
            }
        });
    }

    private void setDummyAdapter() {
        String[] dummyArray = {"TASK 1 DUE 01/25/2017 CHECKED",
                "TASK 2 DUE 05/26/2032 UNCHECKED",
                "TASK 3 DUE 09/26/2324 CHECKED"};
        myListView = (ListView) findViewById(R.id.Task_List);
        myListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummyArray));

    }

    private void gotoTaskEdit() {
        Intent myIntent = new Intent(this, TaskEditActivity.class);
        startActivity(myIntent);
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
}
