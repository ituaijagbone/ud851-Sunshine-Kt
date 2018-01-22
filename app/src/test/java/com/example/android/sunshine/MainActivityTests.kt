package com.example.android.sunshine

import android.widget.TextView
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class MainActivityTests {

    private lateinit var activity: MainActivity
    @Before
    fun setupActivity() {
        val activityController = Robolectric.buildActivity(MainActivity::class.java)
        activity = activityController.get()
        activity.getResponseFromHttpUrl = { _ ->
            fixture()
        }

        activityController.create().visible().start()
    }

    @Test
    fun weatherDisplayDataTextViewIsSetOnCreateView() {
        val textView = activity.findViewById(R.id.tv_weather_data) as TextView
        val expected = OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(activity, fixture())?.joinToString("\n\n\n")
        assertEquals(textView.text, expected)
    }

    @Test
    fun onCreateMenuOptionReturnsTrue() {
        val menu = shadowOf(activity).optionsMenu
        assertEquals(menu.size(), 1)
    }

    @Test
    fun onMenuOptionItemClicked() {
        val refreshMenuItem = shadowOf(activity).optionsMenu.findItem(R.id.action_refresh)
        assertEquals(refreshMenuItem.isVisible, true)
        assertEquals(activity.onOptionsItemSelected(refreshMenuItem), true)
        assertEquals(activity.onOptionsItemSelected(null), false)
    }

    @Test
    fun onActionFreshFetchesNewData() {
        val refreshMenuItem = shadowOf(activity).optionsMenu.findItem(R.id.action_refresh)
        val textView = activity.findViewById(R.id.tv_weather_data) as TextView
        val errorTextView = activity.findViewById(R.id.tv_error_message) as TextView
        assertFalse(errorTextView.isShown)

        activity.getResponseFromHttpUrl = { _ ->
            assertTrue(textView.text.isEmpty())
            fixtureModifiedForRefresh()
        }
        activity.onOptionsItemSelected(refreshMenuItem)

        val expected = OpenWeatherJsonUtils
                .getSimpleWeatherStringsFromJson(activity, fixtureModifiedForRefresh())
                ?.joinToString("\n\n\n")
        assertEquals(textView.text, expected)

        activity.getResponseFromHttpUrl = { _ ->
            null
        }
        activity.onOptionsItemSelected(refreshMenuItem)

        val context = RuntimeEnvironment.application
        assertTrue(errorTextView.isShown)
        assertEquals(errorTextView.text, context.getString(R.string.error_message))
        assertFalse(textView.isShown)

        activity.getResponseFromHttpUrl = { _ ->
            fixtureModifiedForRefresh()
        }
        activity.onOptionsItemSelected(refreshMenuItem)
        assertFalse(errorTextView.isShown)
        assertTrue(textView.isShown)
    }

    @Test
    fun loadingIndicatorToggles() {
        val progressBar = activity.findViewById(R.id.pb_loading_indicator)

        assertFalse(progressBar.isShown)

        activity.getResponseFromHttpUrl = { _ ->
            assertTrue(progressBar.isShown)
            null
        }

        val refreshMenuItem = shadowOf(activity).optionsMenu.findItem(R.id.action_refresh)
        activity.onOptionsItemSelected(refreshMenuItem)

        assertFalse(progressBar.isShown)
    }

    private fun fixture() = "{\n" +
            "  \"city\":   {\n" +
            "    \"id\": 5375480,\n" +
            "    \"name\": \"Mountain View\",\n" +
            "    \"coord\":     {\n" +
            "      \"lon\": -122.08384,\n" +
            "      \"lat\": 37.386051\n" +
            "    },\n" +
            "    \"country\": \"US\",\n" +
            "    \"population\": 0\n" +
            "  },\n" +
            "  \"cod\": \"200\",\n" +
            "  \"message\": 0.0158,\n" +
            "  \"cnt\": 1,\n" +
            "  \"list\":   [\n" +
            "        {\n" +
            "      \"dt\": 1516470909.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 13.32,\n" +
            "        \"max\": 18.27,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.43\n" +
            "      },\n" +
            "      \"pressure\": 996.68,\n" +
            "      \"humidity\": 96,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 500,\n" +
            "        \"main\": \"Light Rain\",\n" +
            "        \"description\": \"Light Rain\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 1.2,\n" +
            "      \"deg\": 0,\n" +
            "      \"clouds\": 20\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    private fun fixtureModifiedForRefresh() = "{\n" +
            "  \"city\":   {\n" +
            "    \"id\": 5375480,\n" +
            "    \"name\": \"Mountain View\",\n" +
            "    \"coord\":     {\n" +
            "      \"lon\": -122.08384,\n" +
            "      \"lat\": 37.386051\n" +
            "    },\n" +
            "    \"country\": \"US\",\n" +
            "    \"population\": 0\n" +
            "  },\n" +
            "  \"cod\": \"200\",\n" +
            "  \"message\": 0.0158,\n" +
            "  \"cnt\": 2,\n" +
            "  \"list\":   [\n" +
            "        {\n" +
            "      \"dt\": 1517507709.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 13,\n" +
            "        \"max\": 18.01,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 989.01,\n" +
            "      \"humidity\": 98,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 901,\n" +
            "        \"main\": \"Tropical Storm\",\n" +
            "        \"description\": \"Tropical Storm\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 110.1,\n" +
            "      \"deg\": 180,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517594109.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 12.2,\n" +
            "        \"max\": 19.01,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 980.01,\n" +
            "      \"humidity\": 99,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 902,\n" +
            "        \"main\": \"Hurricane\",\n" +
            "        \"description\": \"Hurricane\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 148.1,\n" +
            "      \"deg\": 225,\n" +
            "      \"clouds\": 20\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}