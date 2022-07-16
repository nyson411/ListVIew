package app.amano.nayu.listview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityChangeBinding
import app.amano.nayu.listview.utils.getStringArrayList
import org.json.JSONArray

class ChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        val position = intent.getIntExtra("position", 0)
        val intent = Intent(this, MainActivity::class.java)

        binding.deleteButton.setOnClickListener {
            val data = getStringArrayList(this@ChangeActivity)
            data.removeAt(position)
            val jsonArray = JSONArray(data)
            val editor = pref.edit()
            editor.putString("data", jsonArray.toString())
            editor.apply()
            finish()
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            val data = getStringArrayList(this@ChangeActivity)
            data[position] = binding.changeText.text.toString()
            val jsonArray = JSONArray(data)
            val editor = pref.edit()
            editor.putString("data", jsonArray.toString())
            editor.apply()
            finish()
            startActivity(intent)
        }
    }
}
