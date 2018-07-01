package com.acme.a3csci3130;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.clearText;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UpdateTest {
    @Rule
    public ActivityTestRule<MainActivity> ActivityRule = new ActivityTestRule<>(MainActivity.class);
    private String newName;

    @Before
    public void setUp() throws Exception{
        newName="Bob";
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(700);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(clearText());
        onView(withId(R.id.name)).perform(typeText(newName),closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }
}