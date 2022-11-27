package com.example.lab_3.ui

import androidx.lifecycle.*
import com.example.lab_3.data.DataRepository
import com.example.lab_3.domain.model.DomainCard
import com.example.lab_3.presentation.mapper.UiCardMapper
import com.example.lab_3.presentation.uistates.CardsUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel
@Inject
constructor(
    // TODO: implement useCase?
    private val dataRepository: DataRepository,
    private val cardMapper: UiCardMapper,
    private val savedStateHandle: SavedStateHandle
    ): ViewModel() {

    // TODO: should be UI card
    private val _dataState: MutableLiveData<CardsUiState<List<DomainCard>>> = MutableLiveData()

    val dataState: LiveData<CardsUiState<List<DomainCard>>>
        get() = _dataState

    fun setStateEvent(cardsStateEvent: CardsStateEvent) {
        viewModelScope.launch {
            when(cardsStateEvent) {

                is CardsStateEvent.GetCardsEvents -> {
                    dataRepository.getCards()
                        .onEach { dataState ->
                            // TODO: convert to UiCard
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                else -> {

                }
            }
        }
    }
}

sealed class CardsStateEvent {

    object GetCardsEvents: CardsStateEvent()
}