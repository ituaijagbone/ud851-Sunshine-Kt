package com.example.android.sunshine

import com.example.android.sunshine.utilities.NetworkUtils
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class NetworkUtilsTests {
    private val location = "94043,USA"
    @Test
    fun buildUrlWithLocationQuery() {
        val expected = "https://andfun-weather.udacity.com/staticweather?q=94043%2CUSA&mode=json&units=metric&cnt=14"
        val url = NetworkUtils.buildUrl(location)
        assertEquals(url?.toString(), expected)
    }
}