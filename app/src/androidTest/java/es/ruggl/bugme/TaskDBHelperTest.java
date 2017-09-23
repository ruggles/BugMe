package es.ruggl.bugme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ruggl.bugme.Model.Repository.Source.TaskDBHelper;
import es.ruggl.bugme.Model.Repository.Source.TaskDBConfig;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TaskDBHelperTest implements TaskDBConfig {

    private Context appContext;
    private TaskDBHelper myHelper;
    private SQLiteDatabase myDB;

    @Before
    public void beforeTest() {
        appContext = InstrumentationRegistry.getTargetContext();
        appContext.deleteDatabase(TaskDBHelper.DBFILENAME);
        myHelper = TaskDBHelper.getInstance(appContext);
        myDB = myHelper.getWritableDatabase();
    }

    @Test
    public void DatabaseHelper_GivenValidInsert_ReturnsInQuery() {
        ContentValues myValues = new ContentValues(6);

        int id = 1;
        String title = "TEST TITLES";
        String description = "DESCRIPTIO";
        String createdDate = "09/15/1997";
        String dueDate = "09/15/2030";
        int reminder = 0;
        int completed = 1;

        myValues.put(COL_NAME_TITLE, title);
        myValues.put(COL_NAME_DESCRIPTION, description);
        myValues.put(COL_NAME_CREATED_DATE, createdDate);
        myValues.put(COL_NAME_DUE_DATE, dueDate);
        myValues.put(COL_NAME_REMINDER, reminder);
        myValues.put(COL_NAME_COMPLETED, completed);

        System.out.println("Does TaskDBHelper instantiate?");
        myDB.insert(TABLE_NAME, COL_NAME_DESCRIPTION, myValues);

        Cursor myCursor = myDB.query(TABLE_NAME, COLUMN_NAMES, null, null, null, null, null);

        myCursor.moveToFirst();

        System.out.println(myCursor.getCount());

        assertEquals(myCursor.getInt(0), id);
        assertEquals(myCursor.getString(1), title);
        assertEquals(myCursor.getString(2), description);
        assertEquals(myCursor.getString(3), createdDate);
        assertEquals(myCursor.getString(4), dueDate);
        assertEquals(myCursor.getInt(5), reminder);
        assertEquals(myCursor.getInt(6), completed);
    }
}
