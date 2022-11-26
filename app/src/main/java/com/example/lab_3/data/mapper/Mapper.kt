package com.example.lab_3.data.mapper

interface Mapper<RemoteEntity, DomainModel> {
    fun mapEntityModel(remoteEntity: RemoteEntity): DomainModel;

    fun mapModelEntity(domainModel: DomainModel): RemoteEntity
}