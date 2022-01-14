package com.shusharin.harrypotterapp.ui

import com.shusharin.harrypotterapp.R
import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.ErrorType
import com.shusharin.harrypotterapp.domain.PersonDomain
import com.shusharin.harrypotterapp.domain.PersonDomainToUiMapper

sealed class ListPersonUi : Abstract.Object<Unit, PersonListCommunication> {

    class Success(
        private val listPerson: List<PersonDomain>,
        private val personMapper: PersonDomainToUiMapper,
    ) : ListPersonUi() {
        override fun map(mapper: PersonListCommunication) {
            val personsUi = listPerson.map {
                it.map(personMapper)
            }
            mapper.map(personsUi)
        }
    }

    class Fail(
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider,
    ) : ListPersonUi() {
        override fun map(mapper: PersonListCommunication) {
            val messageId = when (errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable_message
                else -> R.string.something_went_wrong
            }
            val message = resourceProvider.getString(messageId)
            mapper.map(listOf(PersonUi.Fail(message)))
        }
    }
}