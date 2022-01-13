package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.data.net.PersonCloud
import com.shusharin.harrypotterapp.data.net.PersonsService

interface ListPersonCloudDataSource {
    suspend fun fetchListPerson(): List<PersonCloud>

    class Base(private val service: PersonsService) : ListPersonCloudDataSource {
        override suspend fun fetchListPerson(): List<PersonCloud> = service.fetchBooks()
    }
}