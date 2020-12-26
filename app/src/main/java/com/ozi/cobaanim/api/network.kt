package com.ozi.cobaanim.api

import com.ozi.cobaanim.model.Responsekaltim
import com.ozi.cobaanim.world.Meninggal
import com.ozi.cobaanim.world.Positif
import com.ozi.cobaanim.world.Sembuh
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface network{
    @GET("kasus")
    fun getData(): Call<List<Responsekaltim>>

}