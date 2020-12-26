package com.ozi.cobaanim.api2

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozi.cobaanim.api.apiservice
import com.ozi.cobaanim.model2.ResponseIndo
import com.ozi.cobaanim.world.Meninggal
import com.ozi.cobaanim.world.Positif
import com.ozi.cobaanim.world.Sembuh
import io.reactivex.Single
import io.reactivex.functions.Function4
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io

class GlobalindoViewModel : ViewModel() {

    private var indo_= MutableLiveData<List<ResponseIndo>>()
    private var global_= MutableLiveData<ArrayList<Global>>()
    private var status = MutableLiveData<Boolean>()
    private lateinit var globalData : ArrayList<Global>

    init {
        getGlobal()
    }

    @SuppressLint("CheckResult")
    private fun getGlobal() {
        status.value = true
        Single.zip(
            apinet2().service()?.getMeninggalData()!!.subscribeOn(io()),
            apinet2().service()?.getSembuhData()!!.subscribeOn(io()),
            apinet2().service()?.getPositifData()!!.subscribeOn(io()),
            apinet2().service()?.getindo()!!.subscribeOn(io()),
            Function4<Meninggal, Sembuh, Positif,List<ResponseIndo>, ArrayList<Global>>
            { globalmeninggal, globalsembuh, globalpositif,indo->
                return@Function4 dataGlobal(globalmeninggal,globalsembuh,globalpositif,indo)
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { global ->
                    global_.postValue(global)
                    status.value = false
                },
                { error ->
                    status.value = false
                    Log.e("error",error.message.toString()) }
            )
    }

    fun dataGlobal(meninggal: Meninggal,
                   sembuh: Sembuh,
                   positif: Positif,
                   indonesia: List<ResponseIndo>) : ArrayList<Global> {

        globalData = ArrayList()
        //global meninggal
        val globalmeniggal = Global()
        globalmeniggal.name = meninggal.name
        globalmeniggal.value = meninggal.value
        globalData.add(globalmeniggal)
        // global sembuh
        val globalsembuh = Global()
        globalsembuh.name = sembuh.name
        globalsembuh.value = sembuh.value
        globalData.add(globalsembuh)
        // global positif
        val globalpositif = Global()
        globalpositif.name = positif.name
        globalpositif.value = positif.value
        globalData.add(globalpositif)

        indo_.postValue(indonesia)

        return globalData
    }

    fun getData() : MutableLiveData<ArrayList<Global>> {
        return global_
    }

    fun getDataIndo() : MutableLiveData<List<ResponseIndo>> {
        return indo_
    }

    fun getStatus():MutableLiveData<Boolean>{
        return status
    }

}