package app.amano.nayu.listview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityAddBinding
import app.amano.nayu.listview.utils.MEMO_LIST_KEY
import app.amano.nayu.listview.utils.SHARED_PREF_NAME
import app.amano.nayu.listview.utils.getStringArrayList
import org.json.JSONArray

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val memoList = getStringArrayList(this@AddActivity, MEMO_LIST_KEY)

        binding.sendButton.setOnClickListener {
            val text = binding.memoText.text.toString()
            memoList.add(text)
            val editor = pref.edit()
            val jsonArray = JSONArray(memoList)
            editor.putString("data", jsonArray.toString())
            editor.apply()
            finish()
        }
    }
}
