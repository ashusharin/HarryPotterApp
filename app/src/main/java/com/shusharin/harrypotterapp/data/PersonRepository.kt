package com.shusharin.harrypotterapp.data

interface PersonRepository {

    suspend fun fetchListPerson() : ListPersonData

    class Base() : PersonRepository {
        override suspend fun fetchListPerson(): ListPersonData {
            TODO("Not yet implemented")
        }
    }
}