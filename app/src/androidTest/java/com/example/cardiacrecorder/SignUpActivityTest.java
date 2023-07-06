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

public class SignUpActivityTest {
    @Rule
    public ActivityScenarioRule<SignUpActivity> activityRule = new ActivityScenarioRule<>(SignUpActivity.class);


    @Test
    public void  signup()
    {
        onView(withId(R.id.signup_email)).check(matches(isDisplayed()));
        onView(withId(R.id.signup_email)).perform(typeText("tuli@gmail.com"));
        Espresso.pressBack();
        onView(withId(R.id.signup_password)).check(matches(isDisplayed()));
        onView(withId(R.id.signup_password)).perform(typeText("tuli19"));
        Espresso.pressBack();
        onView(withId(R.id.signup_button)).perform(click());


    }
}