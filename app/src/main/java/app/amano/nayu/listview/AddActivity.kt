package app.amano.nayu.listview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityAddBinding
import app.amano.nayu.listview.utils.getStringArrayList
import org.json.JSONArray

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val data = getStringArrayList(this@AddActivity)

        binding.sendButton.setOnClickListener {
            val text = binding.memoText.text.toString()
            data.add(text)
            val editor = pref.edit()
            val jsonArray = JSONArray(data)
            editor.putString("data", jsonArray.toString())
            editor.apply()
            finish()
        }
    }
}
