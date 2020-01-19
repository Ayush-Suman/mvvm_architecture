package a.suman.mvvmarchitecture.Model.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataClassRoom(
    @PrimaryKey
    var img_src:String="",
    var earth_date:String?=null
)