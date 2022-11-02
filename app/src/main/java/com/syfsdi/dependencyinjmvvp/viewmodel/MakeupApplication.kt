package com.syfsdi.dependencyinjmvvp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syfsdi.dependencyinjmvvp.model.ResponseDataMakeup
import com.syfsdi.dependencyinjmvvp.model.ResponseDataMakeupItem
import com.syfsdi.dependencyinjmvvp.network.RestfulApi
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Call
import javax.inject.Inject
import javax.security.auth.callback.Callback

@HiltAndroidApp
class MakeupApplication @Inject constructor(val api : RestfulApi) : ViewModel(){
    lateinit var LiveDataMakeup : MutableLiveData<List<ResponseDataMakeupItem>>


    init {
        LiveDataMakeup = MutableLiveData()
    }

    fun getLiveDataMakeup() : MutableLiveData<List<ResponseDataMakeupItem>> {
        return LiveDataMakeup
    }

    fun CallApiMakeup(){
        api.getAllMakeup()
            .enqueue(object : Callback<List<ResponseDataMakeupItem>>{
             override  fun onResponse(
                 call: Call<List<ResponseDataMakeupItem>>
             )  {
                 if (response.isSuccessful){
                     LiveDataMakeup.postValue(response.body()}
                 }else{
                     LiveDataMakeup.postValue(null)
             }

                override fun onFailure(call: Call<List<ResponseDataMakeupItem>>, t: Throwable){
                    LiveDataMakeup.postValue((null))
                }
            })
    }
}