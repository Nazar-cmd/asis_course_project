package com.example.lab_3.presentation.mapper

import com.example.lab_3.domain.model.DomainCard
import com.example.lab_3.presentation.model.UICard
import javax.inject.Inject

class UiCardMapper
@Inject
constructor(): UiMapper<DomainCard, UICard>
{
    override fun mapDomainToUi(domainModel: DomainCard): UICard {

        return UICard(
            id = domainModel.id,
            name = domainModel.name,
            img = domainModel.img,
            type = domainModel.type,
            cost = domainModel.cost,
            attack = domainModel.attack,
            health = domainModel.health,
            rarity = domainModel.rarity,
            cardSet = domainModel.cardSet
        )
    }
}