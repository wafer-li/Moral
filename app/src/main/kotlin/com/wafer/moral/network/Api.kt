package com.wafer.moral.network

import com.wafer.moral.model.request.LoginRequest
import com.wafer.moral.model.response.ActivitiesResponse
import com.wafer.moral.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * The Api class
 * Please put more info here.
 * @author wafer
 * @since 17/4/15 17:35
 */
interface Api {
    @PUT("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("activity/{student_id}/{limit_num}")
    fun getActivities(@Path("student_id") id: String, @Path("limit_num") limitNumber: Int = 10000): Call<ActivitiesResponse>

}