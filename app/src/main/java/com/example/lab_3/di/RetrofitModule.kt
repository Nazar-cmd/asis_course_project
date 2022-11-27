package com.example.lab_3.di

import com.example.lab_3.data.remote.retrofit.CardRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    /*@Singleton
    @Provides
    fun provideDataMapper(): Mapper<RemoteCard, CacheCard, DomainCard> {
        return Mapper()
    }*/

    private fun createHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "f8d52c44eemshbeaefddd6ad09b5p18bfc4jsndac3daa3fff1")
                    .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                    .build()
            chain.proceed(request)
        }

        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {

        val httpClient = createHttpClient()

        return Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideRemoteService(retrofit: Retrofit.Builder): CardRetrofit {
        return retrofit
            .build()
            .create(CardRetrofit::class.java)
    }
}