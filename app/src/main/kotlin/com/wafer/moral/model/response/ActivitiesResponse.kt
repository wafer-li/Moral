package com.wafer.moral.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ActivitiesResponse(

	@field:SerializedName("student_name")
	@field:Expose
	val studentName: String? = null,

	@field:SerializedName("activity_list")
	@field:Expose
	val activityList: List<ActivityListItem?>? = null,

	@field:SerializedName("total_grade")
	@field:Expose
	val totalGrade: Int? = null,

	@field:SerializedName("result_code")
	@field:Expose
	val resultCode: Int? = null,

	@field:SerializedName("message")
	@field:Expose
	val message: String? = null
)