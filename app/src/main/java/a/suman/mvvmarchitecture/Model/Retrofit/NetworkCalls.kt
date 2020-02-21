package a.suman.mvvmarchitecture.Model.Retrofit

import androidx.lifecycle.LiveData
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkCalls {

    @GET("photos")
    fun getData(@Query("sol") sol:Int, @Query("api_key") api_key: String="9CEiCDSukUbfXe9UCloBSrekqvvnipq9ezhrE4Ny"): Single<DataClass>

}