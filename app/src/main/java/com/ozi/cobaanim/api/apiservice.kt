package com.ozi.cobaanim.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiservice{

    val BASE_URL = "https://covid19.kaltimprov.go.id/api/"
    private var retrofit: Retrofit? = null
    fun getRetrofitClient(): Retrofit? {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttp())
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

    fun getService(): network? {
        return getRetrofitClient()?.create<network>(network::class.java)
    }
}