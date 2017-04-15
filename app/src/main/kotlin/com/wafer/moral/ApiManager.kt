package com.wafer.moral

import android.content.Context
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The ApiManager class
 * Please put more info here.
 * @author wafer
 * @since 17/4/15 17:21
 */
object ApiManager {

    const val BASE_URL = "http://101.200.144.204:23333/junk_moral/"

    private lateinit var context: Context

    lateinit var retrofit: Retrofit
        private set

    lateinit var service: Api
        private set

    private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    fun init(context: Context) {
        Log.d("API MANAGER", "init")

        this.context = context.applicationContext

        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(Api::class.java)
    }
}