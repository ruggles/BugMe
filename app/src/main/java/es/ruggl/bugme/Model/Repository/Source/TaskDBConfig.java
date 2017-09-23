package es.ruggl.bugme.Model.Repository.Source;

/**
 * Created by ruggles on 9/18/17.
 */

// TODO THIS SHOULD NOT BE AN INTERFACE, THIS SHOULD BE A CONFIG OBJECT
public interface TaskDBConfig {

    String DBFILENAME = "task.db";

    String TABLE_NAME = " tasks";
    String COL_NAME_ID = " _id";
    String COL_NAME_TITLE = " title";
    String COL_NAME_DESCRIPTION = " description";
    String COL_NAME_CREATED_DATE = " created_date";
    String COL_NAME_DUE_DATE = " due_date";
    String COL_NAME_REMINDER = " reminder";
    String COL_NAME_COMPLETED = " completed";

    String TYPE_TEXT = " TEXT";
    String TYPE_NUMBER = " INTEGER";

    String COMMA = ",";
    String END_BRACKET = ")";

    String COL_PROPS_ID = " PRIMARY KEY AUTOINCREMENT";
    String COL_PROPS_TITLE = " NONNULL";
    String COL_PROPS_DESCRIPTION = "";
    String COL_PROPS_CREATED_DATE = " NONNULL";
    String COL_PROPS_DUE_DATE = " NONNULL";
    String COL_PROPS_REMINDER = " NONNULL";
    String COL_PROPS_COMPLETED = " NONNULL";


    String[] COLUMN_NAMES =
            {COL_NAME_ID,
            COL_NAME_TITLE,
            COL_NAME_DESCRIPTION,
            COL_NAME_CREATED_DATE,
            COL_NAME_DUE_DATE,
            COL_NAME_REMINDER,
            COL_NAME_COMPLETED};

    String[][] DB_STRUCTURE = new String[][]{
            // Has structure: Column name, type, properties, separator
            {COL_NAME_ID, TYPE_NUMBER, COL_PROPS_ID, COMMA},
            {COL_NAME_TITLE, TYPE_TEXT, COL_PROPS_TITLE, COMMA},
            {COL_NAME_DESCRIPTION, TYPE_TEXT, COL_PROPS_DESCRIPTION, COMMA},
            {COL_NAME_CREATED_DATE, TYPE_TEXT, COL_PROPS_CREATED_DATE, COMMA},
            {COL_NAME_DUE_DATE, TYPE_TEXT, COL_PROPS_DUE_DATE, COMMA},
            {COL_NAME_REMINDER, TYPE_NUMBER, COL_PROPS_REMINDER, COMMA},
            {COL_NAME_COMPLETED, TYPE_NUMBER, COL_PROPS_COMPLETED, END_BRACKET}};
}
