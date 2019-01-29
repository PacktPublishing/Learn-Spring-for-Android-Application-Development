package com.sunnat629.testingwithespresso

import android.support.constraint.ConstraintLayout
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.view.View
import org.hamcrest.Matcher


object MyViewAction {

    fun clickChildViewWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun perform(uiController: UiController?, view: View?) {
                val mView = view!!.findViewById<ConstraintLayout>(id)
                mView.performClick()
            }
        }
    }
}

