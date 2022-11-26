package com.example.lab_3.data.remote.model

import com.example.lab_3.data.remote.model.Constants.NAME
import com.example.lab_3.data.remote.model.Constants.CARD_ID
import com.example.lab_3.data.remote.model.Constants.CARD_SET
import com.example.lab_3.data.remote.model.Constants.RARITY
import com.example.lab_3.data.remote.model.Constants.ATTACK
import com.example.lab_3.data.remote.model.Constants.COST
import com.example.lab_3.data.remote.model.Constants.HEALTH
import com.example.lab_3.data.remote.model.Constants.IMAGE
import com.example.lab_3.data.remote.model.Constants.TYPE
import com.google.gson.annotations.SerializedName

data class RemoteCard(
 @SerializedName(NAME) val name: String,
 @SerializedName(CARD_ID) val id: String,
 @SerializedName(CARD_SET) val cardSet: String,
 @SerializedName(TYPE) val type: String,
 @SerializedName(RARITY) val rarity: String?,
 @SerializedName(ATTACK) val attack: Int?,
 @SerializedName(COST) val cost: Int?,
 @SerializedName(HEALTH) val health: Int?,
 @SerializedName(IMAGE) val image: String?,
)
