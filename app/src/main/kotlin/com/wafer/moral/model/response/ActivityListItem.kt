package com.wafer.moral.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActivityListItem(

	@field:SerializedName("activity_name")
	@field:Expose
	val activityName: String? = null,

	@field:SerializedName("grade")
	@field:Expose
	val grade: Int? = null,

	@field:SerializedName("time")
	@field:Expose
	val time: String? = null
)