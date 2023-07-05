package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void maintest() {
        onView(withId(R.id.signUp)).check(matches(isDisplayed()));//for checking the signUp button
        onView(withId(R.id.signUp)).perform(click());
        onView(withId(R.id.signup)).check(matches(isDisplayed()));
        Espresso.pressBack();
        onView(withId(R.id.signIn)).check(matches(isDisplayed()));
        onView(withId(R.id.signIn)).perform(click());
        onView(withId(R.id.login)).check(matches(isDisplayed()));
        onView(withId(R.id.login_email)).perform(typeText("disha@gmail.com"));
        Espresso.pressBack();
        onView(withId(R.id.login_password)).perform(typeText("dishaa"));
        Espresso.pressBack();
        onView(withId(R.id.login_button)).perform(click());


        onView(withId(R.id.store_records)).check(matches(isDisplayed()));
        onView(withId(R.id.store_records)).perform(click());
        onView(withId(R.id.store)).check(matches(isDisplayed()));
        onView(withId(R.id.store_heart)).perform(typeText("120"));
        Espresso.pressBack();
        onView(withId(R.id.store_systolic)).perform(typeText("140"));
       Espresso.pressBack();
        onView(withId(R.id.store_dyastolic)).perform(typeText("169"));
       Espresso.pressBack();
        onView(withId(R.id.store_date)).perform(typeText("05/07/2023"));
       Espresso.pressBack();
       onView(withId(R.id.store_time)).perform(typeText("9:52"));
       Espresso.pressBack();
       onView(withId(R.id.store_btn)).perform(click());
       // onData(anything()).inAdapterView(withId(R.id.city_list)).atPosition(0).perform(click());


        onView(withId(R.id.show_records)).check(matches(isDisplayed()));
        onView(withId(R.id.show_records)).perform(click());
        onView(withId(R.id.show)).check(matches(isDisplayed()));


    }

}
