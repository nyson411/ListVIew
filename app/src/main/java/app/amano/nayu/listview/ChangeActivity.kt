package app.amano.nayu.listview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityChangeBinding
import app.amano.nayu.listview.utils.MEMO_LIST_KEY
import app.amano.nayu.listview.utils.POSITION_LIST_KEY
import app.amano.nayu.listview.utils.SHARED_PREF_NAME
import app.amano.nayu.listview.utils.getStringArrayList
import org.json.JSONArray

class ChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val position = intent.getIntExtra(POSITION_LIST_KEY, 0)
        val intent = Intent(this, MainActivity::class.java)

        binding.deleteButton.setOnClickListener {
            val memoList = getStringArrayList(this@ChangeActivity, MEMO_LIST_KEY)
            memoList.removeAt(position)
            val jsonArray = JSONArray(memoList)
            val editor = pref.edit()
            editor.putString(MEMO_LIST_KEY, jsonArray.toString())
            editor.apply()
            finish()
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            val memoList = getStringArrayList(this@ChangeActivity, MEMO_LIST_KEY)
            memoList[position] = binding.changeText.text.toString()
            val jsonArray = JSONArray(memoList)
            val editor = pref.edit()
            editor.putString(MEMO_LIST_KEY, jsonArray.toString())
            editor.apply()
            finish()
            startActivity(intent)
        }
    }
}
