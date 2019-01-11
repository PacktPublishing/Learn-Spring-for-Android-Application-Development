//package com.sunnat629.mvvmroomexample
//
//import android.support.test.espresso.Espresso
//import android.support.test.espresso.action.ViewActions.click
//import android.support.test.espresso.action.ViewActions.typeText
//import android.support.test.espresso.matcher.ViewMatchers.withId
//import android.support.test.runner.AndroidJUnit4
//import android.util.Log
//import com.sunnat629.mvvmroomexample.model.Users
//import com.sunnat629.mvvmroomexample.ui.NewUserActivity
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//
//@RunWith(AndroidJUnit4::class)
//class MainActivityInstrumentationTest {
//
//    @Rule
//    @JvmField
//    val rule = ActivityTestRule(NewUserActivity::class.java)
//
//    private val newUser = Users(
//        "Mirza", "mirza123@gmail.com",
//        "98765421", "Dhaka"
//    )
//
//
//    @Test
//    fun addNewUserTest() {
//
//        Espresso.onView(withId(R.id.editUsername))
//            .perform(typeText(newUser.username))
//        Espresso.onView(withId(R.id.editEmail))
//            .perform(typeText(newUser.email))
//        Espresso.onView(withId(R.id.editContactID))
//            .perform(typeText(newUser.contactNumber))
//        Espresso.onView(withId(R.id.editAddress))
//            .perform(typeText(newUser.address),closeSoftKeyboard())
//
//
//        Espresso.onView(withId(R.id.buttonSave))
//            .perform(click())
//        Log.i("@Test", "New User adding testing is passed")
//
////        Espresso.onView(withId(R.id.editAddress))
////            .perform(typeText(newUser.address))
//    }
//
//    @Test
//    fun inputFailure(){
//        Espresso.onView(withId(R.id.editUsername))
//            .perform(typeText(newUser.username))
//        Espresso.onView(withId(R.id.editEmail))
//            .perform(typeText(newUser.email))
//        Espresso.onView(withId(R.id.editContactID))
//            .perform(typeText(newUser.contactNumber),closeSoftKeyboard())
//
//
//        Espresso.onView(withId(R.id.buttonSave))
//            .perform(click())
//
//        Log.e("@Test", "Adding new user is failed")
//
//    }
//}