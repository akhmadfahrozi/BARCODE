package com.ozi.cobaanim.api2


import com.google.gson.annotations.SerializedName


data class Attributes(

	@field:SerializedName("OBJECTID")
	val oBJECTID: Int? = null,

	@field:SerializedName("Long_")
	val long: Int? = null,

	@field:SerializedName("Recovered")
	val recovered: Int? = null,

	@field:SerializedName("Country_Region")
	val countryRegion: String? = null,

	@field:SerializedName("Active")
	val active: Int? = null,

	@field:SerializedName("Last_Update")
	val lastUpdate: Long? = null,

	@field:SerializedName("Deaths")
	val deaths: Int? = null,

	@field:SerializedName("Confirmed")
	val confirmed: Int? = null,

	@field:SerializedName("Lat")
	val lat: Int? = null
)