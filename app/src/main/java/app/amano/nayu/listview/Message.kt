package app.amano.nayu.listview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "main")
    var main: String,
)