package com.example.lab_3.ui.cards

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_3.R
import com.example.lab_3.data.mock.model.MockCard

// TODO: on bind view holder?
class CardsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    val cardImageView: AppCompatImageView = itemView.findViewById(R.id.card_image);
    val cardNameView: TextView = itemView.findViewById(R.id.card_name);
    val cardTypeView: TextView = itemView.findViewById(R.id.card_type);
    val cardViewMore: Button = itemView.findViewById(R.id.view_more);

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

    fun setViewMoreHandler(card: MockCard) {
        val bundle = bundleOf(
            "image" to card.img,
            "cardSet" to card.cardSet,
            "name" to card.name,
            "attack" to card.attack,
            "cost" to card.cost,
            "health" to card.health,
            "rarity" to card.rarity,
        )
        cardViewMore.setOnClickListener {
            Navigation
                .findNavController(itemView)
                .navigate(R.id.cardDetailFragment, bundle)
        }
    }
}