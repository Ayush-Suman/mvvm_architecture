package a.suman.mvvmarchitecture.Model.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [DataClassRoom::class], version=1)
abstract class DatabaseRoom:RoomDatabase() {
    abstract fun getRoomMethods():RoomMethods

    companion object {
        @Volatile
        private var instance:DatabaseRoom?= null
        fun createDatabase(context:Context):DatabaseRoom{
            val instance=databaseBuilder(context.applicationContext,
                DatabaseRoom::class.java,
                "nasa").build()

             Companion.instance= instance

            return instance
        }
    }
}