package app.amano.nayu.listview.utils

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
const val MEMO_LIST_KEY: String = "MEMO_LIST_KEY"
const val POSITION_LIST_KEY: String = "POSITION_LIST_KEY"

internal fun getStringArrayList(context: Context, key: String): ArrayList<String> {
    val pref: SharedPreferences = context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
    val arrayString = pref.getString(MEMO_LIST_KEY, null)

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
