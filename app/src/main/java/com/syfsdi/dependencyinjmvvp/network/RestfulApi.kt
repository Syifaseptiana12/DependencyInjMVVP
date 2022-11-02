package com.syfsdi.dependencyinjmvvp.network

import com.syfsdi.dependencyinjmvvp.model.ResponseDataMakeupItem
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApi {
    @GET("admin/car")
    fun getAllMakeup(): Call<List<ResponseDataMakeupItem>>

    @GET("admin/car/{id}")
    fun getDetailMakeup(@Path("id") id : Int): Call<List<ResponseDataMakeupItem>>

    @DELETE("admin/car/{id}")
    fun deleteMakeup(@Path("id") id : Int) : Call<Int>
}