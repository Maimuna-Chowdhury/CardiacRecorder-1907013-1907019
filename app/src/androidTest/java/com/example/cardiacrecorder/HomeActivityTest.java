package com.example.cardiacrecorder;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {
    @Rule
    public ActivityScenarioRule<ShowRecords> activityRule = new ActivityScenarioRule<>(ShowRecords.class);
//    @Test
//    public void home()
//    {
//        onView(withId(R.id.store_records)).check(matches(isDisplayed()));
//        onView(withId(R.id.store_records)).perform(click());
//        onView(withId(R.id.store)).check(matches(isDisplayed()));
//        //Espresso.pressBack();
//        //onView(withId(R.id.show_records)).check(matches(isDisplayed()));
//        onView(withId(R.id.store_heart)).check(matches(isDisplayed()));
//        onView(withId(R.id.store_heart)).perform(typeText("120"));
//       Espresso.pressBack();
//        onView(withId(R.id.store_systolic)).check(matches(isDisplayed()));
//       onView(withId(R.id.store_systolic)).perform(typeText("140"));
//       Espresso.pressBack();
//        onView(withId(R.id.store_dyastolic)).check(matches(isDisplayed()));
//        onView(withId(R.id.store_dyastolic)).perform(typeText("169"));
//       Espresso.pressBack();
//        onView(withId(R.id.store_date)).check(matches(isDisplayed()));
//       onView(withId(R.id.store_date)).perform(typeText("05/07/2023"));
//        Espresso.pressBack();
//        onView(withId(R.id.store_time)).check(matches(isDisplayed()));
//        onView(withId(R.id.store_time)).perform(typeText("9:52"));
//       Espresso.pressBack();
//        onView(withId(R.id.store_btn)).check(matches(isDisplayed()));
//       onView(withId(R.id.store_btn)).perform(click());
//        Espresso.pressBack();
//        onView(withId(R.id.show_records)).check(matches(isDisplayed()));
//        Espresso.pressBack();
//
//       // onView(withId(R.id.show_records)).check(matches(isDisplayed()));
//       // onView(withId(R.id.show_records)).perform(click());
//
//
//
//
//    }


    @Test
    public void testDeleteButton() {
        // Wait for the ListView to be displayed
        onView(withId(R.id.show)).check(matches(isDisplayed()));
//        onView(withId(R.id.record_listView)).check(matches(isDisplayed()));
        onView(withId(R.id.show_card)).check(matches(isDisplayed()));
        onView(withId(R.id.record_date)).check(matches(isDisplayed()));
        onView(withId(R.id.record_time)).check(matches(isDisplayed()));
        onView(withId(R.id.record_heart)).check(matches(isDisplayed()));
        onView(withId(R.id.record_systolic)).check(matches(isDisplayed()));
        onView(withId(R.id.record_dyastolic)).check(matches(isDisplayed()));
        onView(withId(R.id.record_comment)).check(matches(isDisplayed()));
        // Perform a click on the delete button at position 0
        onView(withId(R.id.record_delete)).check(matches(isDisplayed()));
        onView(withId(R.id.record_delete)).perform(click());

    }


}