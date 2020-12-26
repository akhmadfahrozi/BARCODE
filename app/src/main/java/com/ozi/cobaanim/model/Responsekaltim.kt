package com.ozi.cobaanim.model


import com.google.gson.annotations.SerializedName


data class Responsekaltim(

	@field:SerializedName("meninggal")
	val meninggal: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("positif")
	val positif: String? = null,

	@field:SerializedName("sembuh")
	val sembuh: String? = null,

	@field:SerializedName("dirawat")
	val dirawat: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("odp")
	val odp: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("pdp")
	val pdp: String? = null
)