package com.alqudri.hallotechnology.model.category

import com.google.gson.annotations.SerializedName

data class Category(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
