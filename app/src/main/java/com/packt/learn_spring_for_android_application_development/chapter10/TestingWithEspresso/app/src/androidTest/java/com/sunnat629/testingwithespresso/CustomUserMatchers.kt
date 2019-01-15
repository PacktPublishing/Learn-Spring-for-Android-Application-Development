package com.sunnat629.testingwithespresso

import android.support.test.espresso.matcher.BoundedMatcher
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher

class CustomUserMatchers {
    companion object {
        fun itemCount(count: Int): Matcher<View>{
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java){
                override fun describeTo(description: Description?) {
                    description!!.appendText("Total User = $count")
                }

                override fun matchesSafely(item: RecyclerView?): Boolean {
                    return item?.adapter?.itemCount == count
                }

            }
        }
    }
}
