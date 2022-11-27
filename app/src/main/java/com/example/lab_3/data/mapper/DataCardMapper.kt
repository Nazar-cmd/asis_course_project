package com.example.lab_3.data.mapper

import com.example.lab_3.data.cache.model.CacheCard
import com.example.lab_3.data.remote.model.RemoteCard
import com.example.lab_3.domain.model.DomainCard
import javax.inject.Inject

class DataCardMapper
@Inject
constructor(): DataMapper<RemoteCard, CacheCard, DomainCard> {

    override fun mapRemoteToDomain(remoteModel: RemoteCard): DomainCard {
        return DomainCard(
            name = remoteModel.name,
            img =  remoteModel.image,
            cost = remoteModel.cost,
            attack = remoteModel.attack,
            health = remoteModel.health,
            rarity = remoteModel.rarity,
            cardSet = remoteModel.cardSet,
            id = remoteModel.id,
            type = remoteModel.type
        )
    }

    override fun mapDomainToRemote(domainModel: DomainCard): RemoteCard {
        return RemoteCard(
            name = domainModel.name,
            image =  domainModel.img,
            cost = domainModel.cost,
            attack = domainModel.attack,
            health = domainModel.health,
            rarity = domainModel.rarity,
            cardSet = domainModel.cardSet,
            id = domainModel.id,
            type = domainModel.type
        )
    }

    fun mapRemoteListDomainList(remoteModel: List<RemoteCard>): List<DomainCard> {
        return remoteModel.map { mapRemoteToDomain(it) }
    }

    override fun mapDatabaseToDomain(databaseModel: CacheCard): DomainCard {
        return DomainCard(
            id =  databaseModel.id,
            name = databaseModel.name,
            cost = databaseModel.cost,
            attack = databaseModel.attack,
            health = databaseModel.health,
            cardSet = databaseModel.card_set,
            img = databaseModel.image,
            type = databaseModel.type,
            rarity = databaseModel.rarity
        )
    }

    override fun mapDomainToDatabase(domainModel: DomainCard): CacheCard {
        return CacheCard(
            id = domainModel.id,
            name = domainModel.name,
            cost = domainModel.cost,
            attack = domainModel.attack,
            health = domainModel.health,
            card_set = domainModel.cardSet,
            type = domainModel.type,
            rarity = domainModel.rarity,
            image = domainModel.img
        )
    }

    fun mapCacheListDomainList(cacheModel: List<CacheCard>): List<DomainCard> {
        return cacheModel.map { mapDatabaseToDomain(it) }
    }
}
