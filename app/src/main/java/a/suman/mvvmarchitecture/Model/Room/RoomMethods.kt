package a.suman.mvvmarchitecture.Model.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface RoomMethods{
    @Query("Select * from DataClassRoom")
    fun getAll(): Observable<List<DataClassRoom>>

    @Query("Delete from DataClassRoom")
    fun deleteAll()

    @Insert
    fun Insert(data:List<DataClassRoom>)

}