package com.acme.a3csci3130;

import static org.junit.Assert.*;
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
/**
 * UI test for delete contact activity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest

public class DeleteTest {
    @Rule
    public ActivityTestRule<MainActivity> ActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void Test() throws InterruptedException {
        Thread.sleep(700);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}