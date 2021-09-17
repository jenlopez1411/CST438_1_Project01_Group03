package com.nayelidj.cst438_1_project01_group03;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> intentsTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testIntent(){
        onView(withId(R.id.createAcctbtn))
                .check(matches(isDisplayed()))
                .perform(click());
        onView(withId(R.id.createTitle))
                .check(matches(isDisplayed()));
    }
}
