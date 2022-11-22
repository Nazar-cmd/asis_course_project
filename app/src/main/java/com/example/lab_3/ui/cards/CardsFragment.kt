package com.example.lab_3.ui.cards

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.R
import com.example.lab_3.data.mock.model.MockCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private lateinit var adapter: CardsAdapter
private lateinit var recyclerView: RecyclerView


class CardsFragment : Fragment(){
    private var cardsArrayList = arrayListOf<MockCard>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        Log.println(Log.INFO, "", cardsArrayList.toString())

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.cards_recycler_view)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CardsAdapter(cardsArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize() {

        var jsonString = requireActivity().applicationContext
            .assets
            .open("cardsList.json")
            .bufferedReader()
            .use { it.readText() }

        val listCardsType = object : TypeToken<List<MockCard>>() {}.type

        cardsArrayList = Gson().fromJson(jsonString, listCardsType)
    }
}