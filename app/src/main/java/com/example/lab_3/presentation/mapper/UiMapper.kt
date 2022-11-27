package com.example.lab_3.presentation.mapper

interface UiMapper <DomainModel, UiModel> {

    fun mapDomainToUi(domainModel: DomainModel): UiModel
}