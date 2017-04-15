package com.wafer.moral.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("account_type")
	@field:Expose
	val accountType: String? = null,

	@field:SerializedName("name")
	@field:Expose
	val name: String? = null,

	@field:SerializedName("result_code")
	@field:Expose
	val resultCode: Int? = null,

	@field:SerializedName("message")
	@field:Expose
	val message: String? = null
)