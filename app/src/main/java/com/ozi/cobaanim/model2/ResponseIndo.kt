package com.ozi.cobaanim.model2


import com.google.gson.annotations.SerializedName


public class ResponseIndo{

	@field:SerializedName("meninggal")
	val meninggal: String? = null

	@field:SerializedName("positif")
	private val positif: String? = null

	@field:SerializedName("sembuh")
	val sembuh: String? = null

	@field:SerializedName("dirawat")
	val dirawat: String? = null

	@field:SerializedName("name")
	val name: String? = null

	fun getpositif(): String? {
		return positif
	}
	}

