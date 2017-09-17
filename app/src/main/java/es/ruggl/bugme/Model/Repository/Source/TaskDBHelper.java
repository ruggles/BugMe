package es.ruggl.bugme.Model.Repository.Source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ruggles on 9/14/17.
 */

public class TaskDBHelper extends SQLiteOpenHelper {

    final static String DBFILENAME = "task.db";
    final static int DBVERSION = 1;

    // Incoming ugly SQL boilerplate

    // Leaving ugly SQL boilerplate

    private static TaskDBHelper instance;

    public static TaskDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new TaskDBHelper(context.getApplicationContext());
        }

        return instance;
    }

    private TaskDBHelper(Context context) {
        super(context, DBFILENAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
