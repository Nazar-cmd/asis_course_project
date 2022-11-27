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
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RemoteCard(
 @SerializedName(NAME)
 @Expose
 val name: String,

 @SerializedName(CARD_ID)
 @Expose
 val id: String,

 @SerializedName(CARD_SET)
 @Expose
 val cardSet: String,

 @SerializedName(TYPE)
 @Expose
 val type: String,

 @SerializedName(RARITY)
 @Expose
 val rarity: String?,

 @SerializedName(ATTACK)
 @Expose
 val attack: Int?,

 @SerializedName(COST)
 @Expose
 val cost: Int?,

 @SerializedName(HEALTH)
 @Expose
 val health: Int?,

 @SerializedName(IMAGE)
 @Expose
 val image: String?,
)
