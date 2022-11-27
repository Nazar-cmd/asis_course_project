package com.example.lab_3.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab_3.data.cache.model.CacheCard

@Database(version = 1, entities = [CacheCard::class], exportSchema = false)
abstract class HeartsoneDatabase : RoomDatabase() {

    abstract fun cardDao(): CardDao

    companion object {
        val DATABASE_NAME: String = "heartstone_db"
    }
}