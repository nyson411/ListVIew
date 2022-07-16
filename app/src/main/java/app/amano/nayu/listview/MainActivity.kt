package app.amano.nayu.listview

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityMainBinding
import app.amano.nayu.listview.utils.getStringArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val data = getStringArrayList(this@MainActivity)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.list.adapter = adapter

        binding.plusButton.setOnClickListener {
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
        val data = getStringArrayList(this@MainActivity)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.list.adapter = adapter
    }
}
