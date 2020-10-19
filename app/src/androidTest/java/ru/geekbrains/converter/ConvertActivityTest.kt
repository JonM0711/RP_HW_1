package ru.geekbrains.converter

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by vmoro on 19.08.2017.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class ConvertActivityTest {
    private var mStringToBeTyped: String? = null

    @get: Rule
    var mActivityRule = ActivityTestRule(
            ConvertActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        mStringToBeTyped = "1"
    }

    @Test
    fun ConvertActivity_toMillsButton_Test() {
        // Type text and then press the button.
        Espresso.onView(ViewMatchers.withId(R.id.inputValue))
                .perform(ViewActions.typeText(mStringToBeTyped), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.convertButton)).perform(ViewActions.click())

        // Check that the text was changed.
        Espresso.onView(ViewMatchers.withId(R.id.inputValue))
                .check(ViewAssertions.matches(ViewMatchers.withText(mStringToBeTyped)))
        Espresso.onView(ViewMatchers.withId(R.id.outputValue))
                .check(ViewAssertions.matches(ViewMatchers.withText("0.28"))) // формат вывода два знака после запятой
    }

    @Test
    @Throws(Exception::class)
    fun AppContext_Test() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals("ru.geekbrains.converter", appContext.packageName)
    }
}