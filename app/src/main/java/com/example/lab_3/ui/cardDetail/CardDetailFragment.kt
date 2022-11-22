package com.example.lab_3.ui.cardDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lab_3.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "name"
private const val ARG_CARD_SET = "cardSet"
private const val ARG_RARITY = "rarity"
private const val ARG_HEALTH = "health"
private const val ARG_ATTACK = "attack"
private const val ARG_COST = "cost"
private const val ARG_IMAGE = "image"

/**
 * A simple [Fragment] subclass.
 * Use the [CardDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var cardSet: String? = null
    private var rarity: String? = null
    private var health: Int? = null
    private var attack: Int? = null
    private var cost: Int? = null
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            attack = it.getInt(ARG_ATTACK)
            cardSet = it.getString(ARG_CARD_SET)
            health = it.getInt(ARG_HEALTH)
            cost = it.getInt(ARG_COST)
            rarity = it.getString(ARG_RARITY)
            imageUrl = it.getString(ARG_IMAGE, null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_card_detail, container, false);

        val image = view.findViewById<ImageView>(R.id.image_view)
        val nameText = view.findViewById<TextView>(R.id.name)
        val attackText = view.findViewById<TextView>(R.id.attack)
        val costText = view.findViewById<TextView>(R.id.cost)
        val healthText = view.findViewById<TextView>(R.id.health)
        val rarityText = view.findViewById<TextView>(R.id.rarity)
        val cardSetText = view.findViewById<TextView>(R.id.card_set)

        val backButton = view.findViewById<Button>(R.id.back_to_list)

        Glide.with(view.context)
            .load(imageUrl)
            .placeholder(R.drawable.card_border)
            .into(image)

        nameText.text = name
        attackText.text = "Attack: ${attack.toString()}"
        costText.text = "Cost: ${cost.toString()}"
        healthText.text = "Health: ${health.toString()}"
        rarityText.text = "Rarity: $rarity"
        cardSetText.text = "Card Set: $cardSet"

        backButton.setOnClickListener{
            findNavController().navigate(R.id.action_cardDetailFragment_to_cardsFragment)
        }

        return view
    }
}