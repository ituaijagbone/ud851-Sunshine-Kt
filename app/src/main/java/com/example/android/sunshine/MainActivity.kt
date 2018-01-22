/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.android.sunshine.data.SunshinePreferences
import com.example.android.sunshine.utilities.NetworkUtils
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils
import org.json.JSONException
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var mWeatherDisplayTextView: TextView
    var getResponseFromHttpUrl:(URL) -> String? = NetworkUtils::getResponseFromHttpUrl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        mWeatherDisplayTextView = findViewById(R.id.tv_weather_data) as TextView

        loadWeatherData()
    }

    private fun loadWeatherData() {
        val location = SunshinePreferences.getPreferredWeatherLocation(this)
        FetchWeatherTaskAsyncTask().execute(location)
    }

    private inner class FetchWeatherTaskAsyncTask : AsyncTask<String?, Unit, Array<String>?>() {
        override fun doInBackground(vararg params: String?): Array<String>? {
            val location = params[0]!!
            return try {
                NetworkUtils.buildUrl(location)?.let {
                    getResponseFromHttpUrl(it)?.let {
                        OpenWeatherJsonUtils
                                .getSimpleWeatherStringsFromJson(this@MainActivity, it)
                    }
                }
            } catch (e: IOException) {
                return null
            } catch (e: JSONException) {
                return null
            }
        }

        override fun onPostExecute(result: Array<String>?) {
            if (result != null && result.isNotEmpty()) {
                mWeatherDisplayTextView.text = result.joinToString("\n\n\n")
            }
        }
    }
}