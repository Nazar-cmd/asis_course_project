package com.example.lab_3.di

import com.example.lab_3.data.DataRepository
import com.example.lab_3.data.cache.database.CardDao
import com.example.lab_3.data.mapper.DataCardMapper
import com.example.lab_3.data.remote.retrofit.CardRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(
        cardDao: CardDao,
        cardRetrofit: CardRetrofit,
        cardMapper: DataCardMapper
    ): DataRepository {
        return DataRepository(cardDao, cardRetrofit, cardMapper)
    }
}