package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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


    }
}
