package app.amano.nayu.listview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.amano.nayu.listview.databinding.ActivityAddBinding
import app.amano.nayu.listview.utils.*
import app.amano.nayu.listview.utils.getStringArrayList
import app.amano.nayu.listview.utils.putStringArrayList
import org.json.JSONArray

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(this@AddActivity)!!

        val intent = Intent(this, MainActivity::class.java)
        binding = ActivityAddBinding.inflate(layoutInflater).apply { setContentView(this.root) }

//        val pref: SharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//        val titleList = getStringArrayList(this@AddActivity, TITLE_LIST_KEY)
//        val messageList= getStringArrayList(this@AddActivity, MESSAGE_LIST_KEY)


        binding.sendButton.setOnClickListener {
            val title = binding.titleText.text.toString()
            val main = binding.messageText.text.toString()
//            titleList.add(title)
//            messageList.add

//            putStringArrayList(this, TITLE_LIST_KEY,titleList)
//            putStringArrayList(this, MESSAGE_LIST_KEY,messageList)

            val message=Message(title=title,main=main)
            db.messageDao().insert(message)
            startActivity(intent)
        }
    }


}
