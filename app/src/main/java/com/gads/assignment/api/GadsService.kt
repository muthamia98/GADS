package com.gads.assignment.api

import com.gads.assignment.models.LearningLeader
import com.gads.assignment.models.SkillIQLeader
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface GadsService {

    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearningLeader>>

    @GET("api/skilliq")
    fun getSkillIQLeaders(): Call<List<SkillIQLeader>>

    companion object {
        fun create(): GadsService =
            Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(GadsService::class.java)

    }
}
