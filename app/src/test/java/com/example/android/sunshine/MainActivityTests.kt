package com.example.android.sunshine

import android.widget.TextView
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTests {
    @Test
    fun weatherDisplayDataTextViewIsSetOnCreateView() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val textView = activity.findViewById(R.id.tv_weather_data) as TextView
        assertEquals(textView.text, "Sunday - Sunny - 10/12\n\n\nMonday - rainy - 10/12")
    }
}