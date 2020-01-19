package a.suman.mvvmarchitecture.ViewModel

import a.suman.mvvmarchitecture.Model.Repository
import a.suman.mvvmarchitecture.Model.Retrofit.NetworkCalls
import a.suman.mvvmarchitecture.Model.Room.DataClassRoom
import a.suman.mvvmarchitecture.Model.Room.DatabaseRoom
import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ViewModel(application: Application) : AndroidViewModel(application){

    val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()

    val retrofit= Retrofit.Builder().
        baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/").
        addConverterFactory(gsonConverterFactory).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
        build()
    val networkCalls=retrofit.create(NetworkCalls::class.java)

    val roomMethods = DatabaseRoom.createDatabase(application).getRoomMethods()

    val repository=Repository(roomMethods, networkCalls)

    val listDataLive:MutableLiveData<List<DataClassRoom>> =MutableLiveData()
    fun getViewData(int: Int):MutableLiveData<List<DataClassRoom>>{
        repository.getData(int)

        listDataLive.postValue(repository.listData)
        return listDataLive
    }
}
