package com.example.lab_3.ui.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.R
import com.example.lab_3.data.mock.model.MockCard

class CardsAdapter(private val cardsList: ArrayList<MockCard>) : RecyclerView.Adapter<CardsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)

        return CardsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val currentCard = cardsList[position]

        holder.setImage(currentCard.img)
        holder.setName(currentCard.name)
        holder.setType(currentCard.type)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }
}