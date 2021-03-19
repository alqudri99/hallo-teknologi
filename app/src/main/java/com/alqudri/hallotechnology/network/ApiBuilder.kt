package com.alqudri.hallotechnology.network


import android.annotation.SuppressLint
import android.os.Build
import com.alqudri.hallotechnology.helper.StaticValue
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by communitydevpadang in 2020.
 */
object ApiBuilder {
    lateinit var request: Request
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val headerInterceptor = object : Interceptor {


        @SuppressLint("ConstantLocale")
        override fun intercept(chain: Interceptor.Chain): Response {
            request = chain.request()

                    request = request.newBuilder()
                        .addHeader("x-device-type", Build.DEVICE)
                        .addHeader("Accept-Language", Locale.getDefault().language)
                        .build()

            val response = chain.proceed(request)

            return response
        }
    }

    private val okHttp = OkHttpClient.Builder()
        .callTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    private val builder = Retrofit.Builder().baseUrl(StaticValue.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }


}