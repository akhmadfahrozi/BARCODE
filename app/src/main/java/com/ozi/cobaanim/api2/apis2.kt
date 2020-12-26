package com.ozi.cobaanim.api2

import com.ozi.cobaanim.model2.ResponseIndo
import com.ozi.cobaanim.world.Meninggal
import com.ozi.cobaanim.world.Positif
import com.ozi.cobaanim.world.Sembuh
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET


interface apis2{
    @GET("indonesia")
    fun getindo(): Single<List<ResponseIndo>>
    @GET("api")
    fun getworlddata(): Single<List<Worlddata>>

    @GET("meninggal")
    fun getMeninggalData(): Single<Meninggal>

    @GET("positif")
    fun getPositifData(): Single<Positif>

    @GET("sembuh")
    fun getSembuhData(): Single<Sembuh>
}