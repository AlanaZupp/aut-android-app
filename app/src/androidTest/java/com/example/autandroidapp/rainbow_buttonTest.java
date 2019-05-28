package com.example.autandroidapp;

import android.os.Looper;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class rainbow_buttonTest {

    @Rule
    public ActivityTestRule<rainbow_button> rainbowTestRule = new ActivityTestRule<rainbow_button>(rainbow_button.class);
    private rainbow_button rainbowActivity = null;

    //method to get architecture activity for testing
    @Before
    public void setUp() {
        rainbowActivity = rainbowTestRule.getActivity();
        Looper.prepare();
    }

    //a method to test the home button being pressed
    @Test
    public void homeActivity(){
        onView(withId(R.id.action_home)).perform(click());
        assertEquals(rainbowActivity.getCurrentFocus(), new MainActivity().getCurrentFocus());
    }

    @After
    public void tearDown()  {
        rainbowActivity = null;
    }
}