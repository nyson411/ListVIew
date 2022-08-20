package app.amano.nayu.listview

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.amano.nayu.listview.databinding.ActivityMainBinding
import app.amano.nayu.listview.utils.POSITION_LIST_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        db = AppDatabase.getInstance(applicationContext)!!


        val adapter = ListAdapter(this@MainActivity)
        val dividerItemDecoration =
            DividerItemDecoration(this, LinearLayoutManager(this).getOrientation())
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val titleList= getStringArrayList(this, TITLE_LIST_KEY)
//        val messageList = getStringArrayList(this, MESSAGE_LIST_KEY)
//        adapter.titleList.addAll(titleList)
//        adapter.messageList.addAll(messageList)
        //db = AppDatabase.getInstance(this.applicationContext)!!
        adapter.messageList.addAll(db.messageDao().getAll())



        binding.plusButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }


        adapter.setOnItemClickListener(object : ListAdapter.OnItemClickListener {
            override fun onItemClickListener(position: Int, clickedText: String) {
                val intent = Intent(this@MainActivity, ChangeActivity::class.java)
                intent.putExtra(POSITION_LIST_KEY, position)
                startActivity(intent)
            }
        })
        binding.plusButton.setOnClickListener() {
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }

    }

}
