package es.ruggl.bugme;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import es.ruggl.bugme.Model.Repository.Source.TaskDBHelper;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TaskDBHelperTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("es.ruggl.bugme", appContext.getPackageName());
    }

    @Test
    public void testHelper() {
        System.out.println("Does TaskDBHelper work?");
        TaskDBHelper myHelper = TaskDBHelper.getInstance(InstrumentationRegistry.getTargetContext());
    }
}
