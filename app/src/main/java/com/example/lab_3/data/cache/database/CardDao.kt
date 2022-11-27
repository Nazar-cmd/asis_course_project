package com.example.lab_3.data.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lab_3.data.cache.model.CacheCard

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardModel: CacheCard): Long

    @Query(DatabaseConfigs.Queries.SELECT_ALL_FROM_CARDS)
    suspend fun get(): List<CacheCard>
}