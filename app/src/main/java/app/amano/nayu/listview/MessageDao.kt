package app.amano.nayu.listview

import android.app.Notification

import androidx.room.*

@Dao
interface MessageDao {
    @Insert
    fun insert(message: Message)
    @Update
    fun update(message: Message)
    @Delete
    fun delete(message:Message)

    @Query("select * from messages")
    fun getAll():List<Message>
    @Query("delete from messages")
    fun deleteAll()
    @Query("select*from messages where uid=:id" )
    fun getUser(id: Int): Message
}

