package app.amano.nayu.listview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val data = getStringArrayPref()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.list.adapter = adapter
        binding.plusBotton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)

            startActivity(intent)
        }
        binding.list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ChangeActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val data = getStringArrayPref()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.list.adapter = adapter
    }

    private fun getStringArrayPref(): ArrayList<String> {

        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        val list = arrayListOf<String>()

        val a = pref.getString("data", null)
        if (a != null) {
            val jsonArray = JSONArray(a)

            for (i in 0 until jsonArray.length()) {
                list.add(jsonArray.get(i) as String)
            }
            return list
        } else {
            return list
        }
    }
}
