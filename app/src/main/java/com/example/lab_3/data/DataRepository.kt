package com.example.lab_3.data

import com.example.lab_3.data.cache.database.CardDao
import com.example.lab_3.data.cache.model.CacheCard
import com.example.lab_3.data.mapper.DataCardMapper
import com.example.lab_3.data.remote.retrofit.CardRetrofit
import com.example.lab_3.domain.model.DomainCard
import com.example.lab_3.domain.repository.Repository
import com.example.lab_3.presentation.uistates.CardsUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataRepository
constructor(
    private val cardDao: CardDao,
    private val cardRetrofit: CardRetrofit,
    private val cardMapper: DataCardMapper,
    ) : Repository {

    override suspend fun getCards(): Flow<CardsUiState<List<DomainCard>>> = flow {
        emit(CardsUiState.Loading)

        try {
            var cachedCards: List<CacheCard> = cardDao.get()

            if  (cachedCards.isNotEmpty()) {
                emit(CardsUiState.Success(cardMapper.mapCacheListDomainList(cachedCards)))
            }

            val remoteCards = cardRetrofit.getBasicSetCards();

            val domainCards = cardMapper.mapRemoteListDomainList(remoteCards)

            for (domainCard in domainCards) {

                val cacheCard = cardMapper.mapDomainToDatabase(domainCard)

                cardDao.insert(cacheCard);
            }

            cachedCards = cardDao.get()

            emit(CardsUiState.Success(cardMapper.mapCacheListDomainList(cachedCards)))

        } catch (e: Exception) {
            emit(CardsUiState.Error(e))
        }
    }
}