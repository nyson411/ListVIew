package app.amano.nayu.listview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.amano.nayu.listview.databinding.ActivityChangeBinding
import app.amano.nayu.listview.utils.*
import app.amano.nayu.listview.utils.getStringArrayList
import org.json.JSONArray
import java.nio.file.Files.delete

class ChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(this@ChangeActivity)!!

        binding = ActivityChangeBinding.inflate(layoutInflater).apply { setContentView(this.root) }

//        val pref: SharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val position = intent.getIntExtra(POSITION_LIST_KEY, 0)
        val intent = Intent(this, MainActivity::class.java)
        val list= db.messageDao().getAll()

      //  val room = RoomManager(this)

        binding.deleteButton.setOnClickListener {
//            val messageList = getStringArrayList(this@ChangeActivity, MESSAGE_LIST_KEY)
//            val titleList= getStringArrayList(this, TITLE_LIST_KEY)
//            messageList.removeAt(position)
//            titleList.removeAt(position)
//            putStringArrayList(this, MESSAGE_LIST_KEY,messageList)
//            putStringArrayList(this, TITLE_LIST_KEY,titleList)

            val message=Message(uid=list[position].uid,title=list[position].title,main=list[position].main)
            db.messageDao().delete(message)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
//            val messageList = getStringArrayList(this@ChangeActivity, MESSAGE_LIST_KEY)
//            val titleList= getStringArrayList(this, TITLE_LIST_KEY)
            val main = binding.messageText.text.toString()
            val title = binding.titleText.text.toString()
//            putStringArrayList(this, MESSAGE_LIST_KEY,messageList)
//            putStringArrayList(this, TITLE_LIST_KEY,titleList)
            val list= db.messageDao().getAll()
            val message=Message(uid=list[position].uid,title,main)
            db.messageDao().update(message)
            startActivity(intent)
        }
    }
}
