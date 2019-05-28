package com.example.autandroidapp;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


@RunWith(AndroidJUnit4.class)
public class CalendarActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    // before method gets the calendar activity to start testing
    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    //test method launches the calendar activity which has tabbed options
    public void CalendarActivity() {

        View view = mainActivity.findViewById(R.id.calendar);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}