package app.amano.nayu.listview

import android.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityAddBinding
import org.json.JSONArray


class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val pref: SharedPreferences =getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        val data=getStringArrayPref()


        binding.sentBotton.setOnClickListener {
            val text=binding.memoText.text.toString()
            data.add(text)
            val editor=pref.edit()
            val jsonArray=JSONArray(data)
            editor.putString("data",jsonArray.toString())
            editor.apply()
            finish()
        }
    }

    private fun getStringArrayPref():ArrayList<String>  {

        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        val list = arrayListOf<String>()

        val a=pref.getString("data", null)
        if(a!=null) {
            val jsonArray = JSONArray(a)

            for (i in 0 until jsonArray.length()) {
                list.add(jsonArray.get(i) as String)

            }
            return list
        }else{
            return list
        }
    }
}