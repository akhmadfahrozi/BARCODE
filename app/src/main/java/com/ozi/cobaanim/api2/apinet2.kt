package com.ozi.cobaanim.api2

import com.ozi.cobaanim.api.network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class apinet2{

    val BASE_URL = "https://api.kawalcorona.com/"
    private var retrofit: Retrofit? = null
    fun getRetrofitClient(): Retrofit? {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttp())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    private fun getOkHttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return okHttpClient

    }

    fun service(): apis2? {
        return getRetrofitClient()?.create<apis2>(apis2::class.java)
    }
}