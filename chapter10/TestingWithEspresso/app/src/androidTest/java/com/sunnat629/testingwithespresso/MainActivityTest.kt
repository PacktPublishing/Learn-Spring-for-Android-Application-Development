package com.sunnat629.testingwithespresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.sunnat629.testingwithespresso.CustomAssertion.Companion.hasUserCount
import com.sunnat629.testingwithespresso.CustomUserMatchers.Companion.itemCount
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    // User count Matching
    @Test
    fun getCountUser(){
        onView(withId(R.id.userLists))
            .check(matches(itemCount(100)))
    }

    // User count with the help of Assertion
    @Test
    fun getCountUserWithAssertion(){
        onView(withId(R.id.userLists))
            .check(hasUserCount(100))
    }

    // User Click with a position number
    @Test
    fun getUserPosition(){
        onView(withId(R.id.userLists))
            .perform(actionOnItemAtPosition
            <RecyclerView.ViewHolder>(33, click()))
    }

    // User list display test
    @Test
    fun getIsDisplayed(){
        onView(withId(R.id.userLists))
            .check(matches(isDisplayed()))

    }

    // User list display test
    @Test
    fun getIsClickable(){
        onView(withId(R.id.userRoot))
            .check(matches(isClickable()))
    }

    // User list scroll to bottom
    @Test
    fun getScrollToBottom(){
        onView(withId(R.id.userLists))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(activityTestRule.activity.userLists.adapter!!.itemCount - 1))
    }
}