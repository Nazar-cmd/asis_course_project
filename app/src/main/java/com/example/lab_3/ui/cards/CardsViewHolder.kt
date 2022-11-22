package com.example.lab_3.ui.cards

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_3.R

// TODO: on bind view holder?
class CardsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    val cardImageView: AppCompatImageView = itemView.findViewById(R.id.card_image);
    val cardNameView: TextView = itemView.findViewById(R.id.card_name);
    val cardTypeView: TextView = itemView.findViewById(R.id.card_type);

    fun setImage(imageUrl: String?) {
        Glide.with(itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.card_border)
            .into(cardImageView)
    }

    fun setName(name: String) {
        cardNameView.text = name
    }

    fun setType(type: String) {
        cardTypeView.text = type
    }
}