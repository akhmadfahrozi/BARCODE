package com.ozi.cobaanim.world


import com.google.gson.annotations.SerializedName


data class Meninggal(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)