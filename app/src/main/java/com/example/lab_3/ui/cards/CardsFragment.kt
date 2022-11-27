package com.example.lab_3.ui.cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.R
import com.example.lab_3.domain.model.DomainCard
import com.example.lab_3.presentation.uistates.CardsUiState
import com.example.lab_3.ui.CardsStateEvent
import com.example.lab_3.ui.CardsViewModel
import dagger.hilt.android.AndroidEntryPoint

private lateinit var adapter: CardsAdapter
private lateinit var recyclerView: RecyclerView

@AndroidEntryPoint
class CardsFragment : Fragment(){

    private val TAG: String = "Debug"

    private lateinit var errorMessageText: TextView
    private lateinit var progresBar: ProgressBar

    private val viewModel: CardsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("HEEEI")

        subscribeObservers();
        viewModel.setStateEvent(CardsStateEvent.GetCardsEvents)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cards, container, false)

        errorMessageText = view.findViewById(R.id.error_text);
        progresBar = view.findViewById(R.id.progres_bar)
        recyclerView = view.findViewById(R.id.cards_recycler_view)

        return view
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is CardsUiState.Success<List<DomainCard>> -> {
                    displayLoading(false);
                    displayCards(dataState.data)
                }
                is CardsUiState.Error<List<DomainCard>> -> {
                    displayLoading(false);
                    displayError(dataState.exception.message)
                }
                is CardsUiState.Loading-> {
                    displayLoading(true)
                }
            }
        })
    }

    private fun displayCards(cards: List<DomainCard>) {
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CardsAdapter(cards)
        recyclerView.adapter = adapter
    }

    private fun displayError(message: String?) {
        if (message != null) {
            errorMessageText.text = message
        } else {
            errorMessageText.text = "Some error occured"
        }
    }

    private fun displayLoading(isDisplayed: Boolean) {
        progresBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}