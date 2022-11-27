package com.example.lab_3.data.mapper

interface DataMapper<RemoteModel, DatabaseModel, DomainModel> {
    fun mapRemoteToDomain(remoteModel: RemoteModel): DomainModel;

    fun mapDomainToRemote(domainModel: DomainModel): RemoteModel;

    fun mapDatabaseToDomain(databaseModel: DatabaseModel): DomainModel;

    fun mapDomainToDatabase(domainModel: DomainModel): DatabaseModel;
}