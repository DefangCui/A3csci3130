package com.acme.a3csci3130;

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
 * UI test for create contact activity
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateTest {
    @Rule

    public ActivityTestRule<MainActivity> ActivityRule = new ActivityTestRule<>(MainActivity.class);
    private String name;
    private String email;
    private String businessNumber;
    private String primaryBusiness;
    private String address;
    private String province;

    @Before
    public void setUp() throws Exception {
        name="Kris";
        email="df435113@dal.ca";
        businessNumber="123456789";
        primaryBusiness="Fisher";
        address="1200TowerRd";
        province="NS";
    }
    @Test
    public void Test(){
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText(email),closeSoftKeyboard());
        onView(withId(R.id.businum)).perform(typeText(businessNumber),closeSoftKeyboard());
        onView(withId(R.id.pribusi)).perform(typeText(primaryBusiness),closeSoftKeyboard());
        onView(withId(R.id.addR)).perform(typeText(address),closeSoftKeyboard());
        onView(withId(R.id.provin)).perform(typeText(province),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());


    }
}