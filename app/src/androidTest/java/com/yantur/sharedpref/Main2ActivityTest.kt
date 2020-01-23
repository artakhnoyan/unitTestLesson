package com.yantur.sharedpref

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.yantur.sharedpref.old.Main2Activity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
internal class Main2ActivityTest  {

    @get:Rule
    var activityRule: ActivityTestRule<Main2Activity> = ActivityTestRule(
        Main2Activity::class.java)

    @Test
    fun change_view_color() {
        onView(withId(R.id.my_view)).perform(click())
        onView(withId(R.id.green)).check(matches(isDisplayed()))
        onView(withId(R.id.pink)).check(matches(not(isDisplayed())))
    }
}