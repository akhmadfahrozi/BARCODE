package com.ozi.cobaanim.api3

import com.ozi.cobaanim.model2.ResponseIndo
import com.ozi.cobaanim.model3.Responsetambah
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface apis3{
    @GET("tambah_murid")
    fun tambahmurid(
        @Query("nama") nama: String?,
        @Query("positif") positif: String?,
        @Query("meninggal") meninggal: String?,
        @Query("sembuh")sembuh:String?)
            :Call<Responsetambah>

}