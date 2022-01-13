package com.shusharin.harrypotterapp.data.cache

import com.shusharin.harrypotterapp.data.PersonData

interface ListPersonCacheDataSourse {

    fun fetchListPerson(): List<PersonDb>

    fun saveListPerson(persons: List<PersonData>)

    class Base(
        private val realmProvider : RealmProvider,
        private val mapper: PersonDataToDbMapper
    ) : ListPersonCacheDataSourse{
        override fun fetchListPerson(): List<PersonDb> {
            TODO("Not yet implemented")
        }

        override fun saveListPerson(persons: List<PersonData>) {
            TODO("Not yet implemented")
        }
    }

}