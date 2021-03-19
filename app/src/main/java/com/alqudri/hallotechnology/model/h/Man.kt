package com.alqudri.hallotechnology.model.h

import com.google.gson.annotations.SerializedName

data class Man(

	@field:SerializedName("Sheet1")
	val sheet1: List<Sheet1Item?>? = null
)

data class Sheet1Item(

	@field:SerializedName("jns_kelamin")
	val jnsKelamin: String? = null,

	@field:SerializedName("id_status")
	val idStatus: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id_kecelakaan")
	val idKecelakaan: String? = null,

	@field:SerializedName("id_wilayah")
	val idWilayah: String? = null,

	@field:SerializedName("id_kendaraan")
	val idKendaraan: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null
)
