package com.ozi.cobaanim.api3

import com.ozi.cobaanim.api2.apis2
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apin3 {
    val BASE_URL = "https://akhmad-fahrozi.com/ci-apotek/index.php/Obat/"
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

    fun net(): apis3? {
        return getRetrofitClient()?.create<apis3>(apis3::class.java)
    }
}