package com.alqudri.hallotechnology.model.detail

import com.google.gson.annotations.SerializedName

data class Detail(

	@field:SerializedName("data")
	val data: Data? = null
)

data class Data(

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("foto")
	val foto: List<String?>? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("stock")
	val stock: String? = null,

	@field:SerializedName("product_name")
	val productName: String? = null
)
