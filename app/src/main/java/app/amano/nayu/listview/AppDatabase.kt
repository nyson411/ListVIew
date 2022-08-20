package app.amano.nayu.listview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Message::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // TODO: 後でコードを追加する
    abstract fun messageDao(): MessageDao
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "database",
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}