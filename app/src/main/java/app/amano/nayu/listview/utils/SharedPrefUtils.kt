package app.amano.nayu.listview.utils

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

internal fun getStringArrayList(context: Context): ArrayList<String> {
    val pref: SharedPreferences = context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
    val arrayString = pref.getString("data", null)

    val list = arrayListOf<String>()

    return if (arrayString != null) {
        val jsonArray = JSONArray(arrayString)

        for (i in 0 until jsonArray.length()) {
            list.add(jsonArray[i].toString())
        }
        list
    } else {
        list
    }
}
