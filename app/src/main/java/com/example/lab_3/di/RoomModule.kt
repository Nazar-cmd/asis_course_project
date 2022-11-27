package com.example.lab_3.di

import android.content.Context
import androidx.room.Room
import com.example.lab_3.data.cache.database.CardDao
import com.example.lab_3.data.cache.database.HeartsoneDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideHearstoneDb(@ApplicationContext context: Context): HeartsoneDatabase {
        return Room
            .databaseBuilder(
                context,
                HeartsoneDatabase::class.java,
                HeartsoneDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCardDAO(heartsoneDatabase: HeartsoneDatabase): CardDao {
        return heartsoneDatabase.cardDao()
    }
}