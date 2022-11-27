package com.example.lab_3.data.remote.retrofit

import com.example.lab_3.data.remote.model.RemoteCard
import retrofit2.http.GET

interface CardRetrofit {

    @GET("cards/sets/Basic")
    suspend fun getBasicSetCards(): List<RemoteCard>
}