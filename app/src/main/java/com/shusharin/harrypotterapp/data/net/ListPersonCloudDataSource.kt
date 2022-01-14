package com.shusharin.harrypotterapp.data.net

interface ListPersonCloudDataSource {
    suspend fun fetchListPerson(): List<PersonCloud>

    class Base(private val service: PersonsService) : ListPersonCloudDataSource {
        override suspend fun fetchListPerson(): List<PersonCloud> = service.fetchBooks()
    }
}