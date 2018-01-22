package com.example.android.sunshine

import android.widget.TextView
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils
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
        activity.getResponseFromHttpUrl = { _ ->
            fixture()
        }

        val textView = activity.findViewById(R.id.tv_weather_data) as TextView
        val expected = OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(activity, fixture())?.joinToString("\n\n\n")
        assertEquals(textView.text, expected)
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
            "  \"cnt\": 14,\n" +
            "  \"list\":   [\n" +
            "        {\n" +
            "      \"dt\": 1516470909.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 13.32,\n" +
            "        \"max\": 18.27,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
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
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516557309.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 12.66,\n" +
            "        \"max\": 17.34,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 996.12,\n" +
            "      \"humidity\": 97,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 501,\n" +
            "        \"main\": \"Moderate Rain\",\n" +
            "        \"description\": \"Moderate Rain\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 4.8,\n" +
            "      \"deg\": 45,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516643709.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 12.07,\n" +
            "        \"max\": 16.48,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 995.7,\n" +
            "      \"humidity\": 90,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 800,\n" +
            "        \"main\": \"Clear\",\n" +
            "        \"description\": \"Clear\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 8.2,\n" +
            "      \"deg\": 90,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516730109.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 11.53,\n" +
            "        \"max\": 12.34,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 1001.22,\n" +
            "      \"humidity\": 87,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 802,\n" +
            "        \"main\": \"Scattered Clouds\",\n" +
            "        \"description\": \"Scattered Clouds\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 3.6,\n" +
            "      \"deg\": 135,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516816509.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 14.62,\n" +
            "        \"max\": 15.36,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 1001.51,\n" +
            "      \"humidity\": 88,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 803,\n" +
            "        \"main\": \"Broken Clouds\",\n" +
            "        \"description\": \"Broken Clouds\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 4,\n" +
            "      \"deg\": 180,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516902909.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": -2,\n" +
            "        \"max\": -1.1,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 997.54,\n" +
            "      \"humidity\": 78,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 600,\n" +
            "        \"main\": \"Light Snow\",\n" +
            "        \"description\": \"Light Snow\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 2.6,\n" +
            "      \"deg\": 225,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1516989309.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": -1.5,\n" +
            "        \"max\": -1,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 996.55,\n" +
            "      \"humidity\": 80,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 601,\n" +
            "        \"main\": \"Snow\",\n" +
            "        \"description\": \"Snow\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 3.8,\n" +
            "      \"deg\": 270,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517075709.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": -1,\n" +
            "        \"max\": 0.5,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 996.76,\n" +
            "      \"humidity\": 85,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 602,\n" +
            "        \"main\": \"Heavy Snow\",\n" +
            "        \"description\": \"Heavy Snow\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 5.2,\n" +
            "      \"deg\": 315,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517162109.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 0.5,\n" +
            "        \"max\": 2,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 998.56,\n" +
            "      \"humidity\": 90,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 611,\n" +
            "        \"main\": \"Sleet\",\n" +
            "        \"description\": \"Sleet\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 10.3,\n" +
            "      \"deg\": 0,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517248509.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 5,\n" +
            "        \"max\": 7.5,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 1000.21,\n" +
            "      \"humidity\": 80,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 741,\n" +
            "        \"main\": \"Fog\",\n" +
            "        \"description\": \"Fog\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 1.5,\n" +
            "      \"deg\": 45,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517334909.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 10.21,\n" +
            "        \"max\": 12.35,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 1000.11,\n" +
            "      \"humidity\": 97,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 960,\n" +
            "        \"main\": \"Storm\",\n" +
            "        \"description\": \"Storm\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 70.2,\n" +
            "      \"deg\": 90,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
            "        {\n" +
            "      \"dt\": 1517421309.005,\n" +
            "      \"temp\":       {\n" +
            "        \"day\": 29.49,\n" +
            "        \"min\": 12.2,\n" +
            "        \"max\": 19.01,\n" +
            "        \"night\": 9.52,\n" +
            "        \"eve\": 21.09,\n" +
            "        \"morn\": 15.42\n" +
            "      },\n" +
            "      \"pressure\": 990.01,\n" +
            "      \"humidity\": 97,\n" +
            "      \"weather\": [      {\n" +
            "        \"id\": 960,\n" +
            "        \"main\": \"Storm\",\n" +
            "        \"description\": \"Storm\",\n" +
            "        \"icon\": \"02d\"\n" +
            "      }],\n" +
            "      \"speed\": 80.1,\n" +
            "      \"deg\": 135,\n" +
            "      \"clouds\": 20\n" +
            "    },\n" +
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