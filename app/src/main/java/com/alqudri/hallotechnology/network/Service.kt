package com.alqudri.hallotechnology.network

import com.alqudri.hallotechnology.model.Merek
import com.alqudri.hallotechnology.model.category.Category
import com.alqudri.hallotechnology.model.detail.Detail
import com.alqudri.hallotechnology.model.home.HomeModel
import com.alqudri.hallotechnology.model.office.Office
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by communitydevpadang in 2020.
 */
interface Service {
    @GET("category")
    fun getCategory():Call<Category>

    @GET("merek")
    fun getMerek():Call<Merek>

    @GET("product")
    fun getHome():Call<HomeModel>

    @GET("product")
    fun getHome(@Query("merek") merek: String, @Query("category") cat: String, @Query("q") q: String):Call<HomeModel>

    @GET("product/detail")
    fun getgetDetail(@Query("id") cat: String):Call<Detail>


    @GET("office")
    fun getOffice():Call<Office>
}