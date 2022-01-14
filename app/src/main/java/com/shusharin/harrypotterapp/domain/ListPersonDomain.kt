package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.ErrorType
import com.shusharin.harrypotterapp.data.PersonData
import com.shusharin.harrypotterapp.data.PersonDataToDomainMapper
import com.shusharin.harrypotterapp.ui.ListPersonUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class ListPersonDomain : Abstract.Object<ListPersonUi, ListPersonDomainToUiMapper> {

    class Success(
        private val persons: List<PersonData>,
        private val personMapper: PersonDataToDomainMapper,
    ) : ListPersonDomain() {
        override fun map(mapper: ListPersonDomainToUiMapper): ListPersonUi =
            mapper.map(persons.map {
                it.map(personMapper)
            })
    }


    class Fail(private val e: Exception) : ListPersonDomain() {
        override fun map(mapper: ListPersonDomainToUiMapper): ListPersonUi = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}
