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

class ViewModel(application: Application) : AndroidViewModel(application) {
    val repository=Repository(application)
    val listDataLive: MutableLiveData<List<DataClassRoom>> = MutableLiveData()
    init {
        repository.loadData().subscribe {
            listDataLive.postValue(it)
        }
    }



    fun getViewData(int: Int) {
        repository.getData(int)
    }
}
