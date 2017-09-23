package es.ruggl.bugme.Model.Repository.Source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ruggles on 9/14/17.
 */

public class TaskDBHelper extends SQLiteOpenHelper implements TaskDBConfig {

    private final static int DBVERSION = 1;

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

        // Generate Schema based on TaskDBConfig
        String dbSchema = "CREATE TABLE" + TABLE_NAME + "(";
        for (String[] field : DB_STRUCTURE) {
            for (String word: field) {
                dbSchema = dbSchema.concat(word);
            }
        }

        db.execSQL(dbSchema);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
