package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.data.ListPersonDataToDomainMapper
import com.shusharin.harrypotterapp.data.PersonRepository

interface ListPersonInteractor {

    suspend fun fetchListPerson(): ListPersonDomain

    class Base(
        private val personRepository: PersonRepository,
        private val mapper:ListPersonDataToDomainMapper
    ) : ListPersonInteractor{
        override suspend fun fetchListPerson(): ListPersonDomain = personRepository.fetchListPerson().map(mapper)
    }
}