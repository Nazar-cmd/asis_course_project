package com.example.lab_3.domain.model

data class DomainCard(
    var id: String,
    var name: String,
    var img: String?,
    var type: String,
    var cost: Int?,
    var attack: Int?,
    var health: Int?,
    var rarity: String?,
    var cardSet: String,
)
