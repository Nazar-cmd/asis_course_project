package com.example.lab_3.presentation.uistates

sealed class CardsUiState<out R> {

    data class Success<out T>(val data: T): CardsUiState<T>()
    data class Error<out T>(val exception: Exception): CardsUiState<T>()
    object Loading: CardsUiState<Nothing>()
}