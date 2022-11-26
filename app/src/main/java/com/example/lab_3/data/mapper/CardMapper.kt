package com.example.lab_3.data.mapper

import com.example.lab_3.data.remote.model.RemoteCard
import com.example.lab_3.domain.model.DomainCard
import javax.inject.Inject

class CardMapper
@Inject
constructor(): Mapper<RemoteCard, DomainCard> {

    override fun mapEntityModel(remoteEntity: RemoteCard): DomainCard {
        return DomainCard(
            name = remoteEntity.name,
            img =  remoteEntity.image,
            cost = remoteEntity.cost,
            attack = remoteEntity.attack,
            health = remoteEntity.health,
            rarity = remoteEntity.rarity,
            cardSet = remoteEntity.cardSet,
            id = remoteEntity.id,
            type = remoteEntity.type
        )
    }

    override fun mapModelEntity(domainModel: DomainCard): RemoteCard {
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

    fun mapRemoteEntityListDomainList(remoteEntities: List<RemoteCard>): List<DomainCard> {
        return remoteEntities.map { mapEntityModel(it) }
    }
}
