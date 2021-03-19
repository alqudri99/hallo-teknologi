package com.alqudri.hallotechnology.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alqudri.hallotechnology.model.Merek
import com.alqudri.hallotechnology.model.category.Category
import com.alqudri.hallotechnology.model.detail.Detail
import com.alqudri.hallotechnology.model.home.HomeModel
import com.alqudri.hallotechnology.model.office.Office
import com.alqudri.hallotechnology.network.ApiBuilder
import com.alqudri.hallotechnology.network.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel(){
    private val _listCategory = MutableLiveData<Category>()
    val listCategory: LiveData<Category> get() = _listCategory

    private val _listMerek = MutableLiveData<Merek>()
    val listMerek: LiveData<Merek> get() = _listMerek

    private val _listHome = MutableLiveData<HomeModel>()
    val listHome: LiveData<HomeModel> get() = _listHome

    private val _listDetail = MutableLiveData<Detail>()
    val listDetail: LiveData<Detail> get() = _listDetail
    private val _listOffice = MutableLiveData<Office>()
    val listOffice: LiveData<Office> get() = _listOffice

    fun getDetail(id: String) {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getgetDetail(id)


        request.enqueue(object : Callback<Detail>{
            override fun onFailure(call: Call<Detail>, t: Throwable) {

            }

            override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                if(response.isSuccessful){
                    _listDetail.postValue(response.body())
                }
            }

        })
    }

    fun getOffice() {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getOffice()


        request.enqueue(object : Callback<Office>{
            override fun onFailure(call: Call<Office>, t: Throwable) {

            }

            override fun onResponse(call: Call<Office>, response: Response<Office>) {
                if(response.isSuccessful){
                    _listOffice.postValue(response.body())
                }
            }


        })
    }


    fun getCategory() {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getCategory()


        request.enqueue(object : Callback<Category>{
            override fun onFailure(call: Call<Category>, t: Throwable) {
                Log.d("errorrr", ""+t.message)
            }

            override fun onResponse(call: Call<Category>, response: Response<Category>) {
                if(response.isSuccessful){
                    _listCategory.postValue(response.body())
                }
            }

        })
    }



    fun getMerek() {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getMerek()


        request.enqueue(object : Callback<Merek>{
            override fun onFailure(call: Call<Merek>, t: Throwable) {
                Log.d("errorrr", ""+t.message)
            }

            override fun onResponse(call: Call<Merek>, response: Response<Merek>) {
                if(response.isSuccessful){
                    _listMerek.postValue(response.body())
                }
            }

        })
    }

    fun getHome() {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getHome()

        request.enqueue(object : Callback<HomeModel>{
            override fun onFailure(call: Call<HomeModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<HomeModel>, response: Response<HomeModel>) {
                if(response.isSuccessful){
                    _listHome.postValue(response.body())
                }
            }

        })
    }

    fun getHome(q:String, category: String, merek: String) {
        val requestData = ApiBuilder.buildService(Service::class.java)
        val request = requestData.getHome(merek, category,q)

        request.enqueue(object : Callback<HomeModel>{
            override fun onFailure(call: Call<HomeModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<HomeModel>, response: Response<HomeModel>) {
                if(response.isSuccessful){
                    _listHome.postValue(response.body())
                }
            }

        })
    }
}