package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.domain.ListPersonDomain

sealed class ListPersonData : Abstract.Object<ListPersonDomain, ListPersonDataToDomainMapper> {

    data class Success(private val listPerson: List<PersonData>) : ListPersonData() {
        override fun map(mapper: ListPersonDataToDomainMapper): ListPersonDomain =
            mapper.map(listPerson)
    }

    data class Fail(private val e: Exception) : ListPersonData() {
        override fun map(mapper: ListPersonDataToDomainMapper): ListPersonDomain = mapper.map(e)
    }
}
