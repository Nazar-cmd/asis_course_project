package com.example.lab_3.domain.repository

import com.example.lab_3.domain.model.DomainCard
import com.example.lab_3.presentation.uistates.CardsUiState
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend  fun getCards(): Flow<CardsUiState<List<DomainCard>>>
}