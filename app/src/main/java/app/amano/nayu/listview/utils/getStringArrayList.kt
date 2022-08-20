package app.amano.nayu.listview.utils

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray

const val SHARED_PREF_NAME="SHARD_PREF_NAME"
const val MESSAGE_LIST_KEY="MESSAGE_LIST_KEY"
const val TITLE_LIST_KEY="TITLE_LIST_KEY"
const val POSITION_LIST_KEY="POSITION_LIST_KEY"


fun getStringArrayList(context: Context, key: String): ArrayList<String> {
        val pref: SharedPreferences =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)


        val arrayString = pref.getString(key, null)
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

    fun putStringArrayList(context: Context, key: String, content: ArrayList<String>) {
        val pref: SharedPreferences =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val JsonArray = JSONArray(content)
        val editor = pref.edit()
        editor.putString(key, JsonArray.toString())
        editor.apply()

    }