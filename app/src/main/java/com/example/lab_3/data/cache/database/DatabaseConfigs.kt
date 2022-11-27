package com.example.lab_3.data.cache.database

object DatabaseConfigs {

    object Queries {
        const val SELECT_ALL_FROM_CARDS = "SELECT * FROM ${Names.Tables.CARDS}"
    }

    object Names {
        const val DATABASE = "hearthstone-db"

        object Tables {
            const val CARDS = "cards"
        }

        object Columns {
            const val ID = "id"
            const val NAME = "name"
            const val CARD_SET = "card_set"
            const val TYPE = "type"
            const val RARITY = "rarity"
            const val COST = "cost"
            const val ATTACK = "attack"
            const val HEALTH = "health"
            const val IMAGE = "img"
        }
    }
}