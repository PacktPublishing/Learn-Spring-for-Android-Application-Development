package com.sunnat629.testingwithespresso

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.CoreMatchers
import java.lang.IllegalStateException


class CustomAssertion{
    companion object {
        fun hasUserCount(count: Int): ViewAssertion {
            return ViewUserCountAssertion(count)
        }
    }

    class ViewUserCountAssertion(private val count: Int): ViewAssertion{
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null){
                throw noViewFoundException
            }

            if (view !is RecyclerView){
                throw IllegalStateException("I am afraid that this view is not a RecyclerView.")
            }

            if (view.adapter == null){
                throw IllegalStateException("I am afraid that there is no adapter assigned to RecyclerView.")
            }

            ViewMatchers.assertThat("User count", view.adapter!!.itemCount, CoreMatchers.equalTo(count))
        }

    }
}