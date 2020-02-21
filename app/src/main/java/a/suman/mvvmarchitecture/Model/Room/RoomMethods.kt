package a.suman.mvvmarchitecture.Model.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface RoomMethods{
    @Query("Select * from DataClassRoom")
    fun getAll(): Flowable<List<DataClassRoom>>

    @Query("Delete from DataClassRoom")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insert(data:List<DataClassRoom>)

}