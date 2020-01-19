package a.suman.mvvmarchitecture.Model

import a.suman.mvvmarchitecture.Model.Retrofit.DataClass
import a.suman.mvvmarchitecture.Model.Retrofit.NetworkCalls
import a.suman.mvvmarchitecture.Model.Room.DataClassRoom
import a.suman.mvvmarchitecture.Model.Room.DatabaseRoom
import a.suman.mvvmarchitecture.Model.Room.RoomMethods
import android.content.Context
import android.os.AsyncTask
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class Repository(val room: RoomMethods, val networkCalls: NetworkCalls){

    var listData:List<DataClassRoom> =emptyList()


fun getData(int:Int){
    networkCalls.getData(int).subscribeOn(Schedulers.io()).subscribe{t->
        room.deleteAll()
        room.Insert(t.photos)
        listData=t.photos
    }

    room.getAll().subscribeOn(Schedulers.io()).subscribe{t->
        listData=t
    }


}







}