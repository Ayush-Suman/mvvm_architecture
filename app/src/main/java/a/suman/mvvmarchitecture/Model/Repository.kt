package a.suman.mvvmarchitecture.Model

import a.suman.mvvmarchitecture.Model.Retrofit.DataClass
import a.suman.mvvmarchitecture.Model.Retrofit.NetworkCalls
import a.suman.mvvmarchitecture.Model.Room.DataClassRoom
import a.suman.mvvmarchitecture.Model.Room.DatabaseRoom
import a.suman.mvvmarchitecture.Model.Room.RoomMethods
import android.app.Application
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class Repository(application: Application) {

    val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()

    val retrofit= Retrofit.Builder().
        baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/").
        addConverterFactory(gsonConverterFactory).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
        build()
    val networkCalls=retrofit.create(NetworkCalls::class.java)

    val roomMethods = DatabaseRoom.createDatabase(application).getRoomMethods()


    fun getData(int: Int) {
        networkCalls.getData(int).subscribeOn(Schedulers.io()).subscribe({
            roomMethods.deleteAll()
            roomMethods.Insert(it.photos)
        }, {})
    }

    fun loadData(): Flowable<List<DataClassRoom>> {
        return roomMethods.getAll().subscribeOn(Schedulers.io())
    }
}