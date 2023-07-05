package com.example.cardiacrecorder;

import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import android.os.IBinder;
import android.os.SystemClock;
import android.view.WindowManager;
import androidx.test.espresso.Root;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UpdateActivityTest {
    @Rule
    public ActivityScenarioRule<UpdateActivity> activityRule = new ActivityScenarioRule<>(UpdateActivity.class);

    @Test

    public void updateRecordTest() {
        Espresso.onData(anything())
                .inAdapterView(withId(R.id.record_listView))
                .atPosition(position)
                .perform(longClick());
        Espresso.onView(withId(R.id.update_heart)).perform(clearText()).perform(ViewActions.typeText("140"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.update_systolic)).perform(clearText()).perform(ViewActions.typeText("90"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.update_dyastolic)).perform(clearText()).perform(ViewActions.typeText("1100"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.update_date)).perform(clearText()).perform(ViewActions.typeText("05/07/2023"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.update_time)).perform(clearText()).perform(ViewActions.typeText("2:01"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.update_btn)).perform(click());
        SystemClock.sleep(5000);
    }

    /**
     * Tests the delete measurement functionality.
     * Simulates a user long-clicking on a measurement item and clicks the delete button.
     */
    @Test
    public void testDeleteMeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.record_listView)).perform(longClick());
        SystemClock.sleep(1000);
      //  onView(withId(R.id.updat)).perform(click());
        SystemClock.sleep(5000);
    }

}

