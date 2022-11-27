package com.example.lab_3.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab_3.data.cache.database.DatabaseConfigs

@Entity(tableName = DatabaseConfigs.Names.Tables.CARDS)
data class CacheCard(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DatabaseConfigs.Names.Columns.ID)
    var id: String,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.NAME)
    var name: String,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.COST)
    var cost: Int?,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.ATTACK)
    var attack: Int?,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.HEALTH)
    var health: Int?,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.CARD_SET)
    var card_set: String,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.TYPE)
    var type: String,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.RARITY)
    var rarity: String?,

    @ColumnInfo(name = DatabaseConfigs.Names.Columns.IMAGE)
    var image: String?,
)
