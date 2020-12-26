package com.ozi.cobaanim.api2


import com.google.gson.annotations.SerializedName
import com.ozi.cobaanim.api2.Attributes


class Worlddata {

    @field:SerializedName("attributes")
    private var attributes: Attributes? = null

    fun getAttributes(): Attributes? {
        return attributes
    }
}