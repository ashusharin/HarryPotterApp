package com.shusharin.harrypotterapp.ui

import com.shusharin.harrypotterapp.data.ErrorType
import com.shusharin.harrypotterapp.domain.ListPersonDomainToUiMapper
import com.shusharin.harrypotterapp.domain.PersonDomain
import com.shusharin.harrypotterapp.domain.PersonDomainToUiMapper

class BaseListPersonDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val personMapper: PersonDomainToUiMapper,
) : ListPersonDomainToUiMapper {
    override fun map(persons: List<PersonDomain>) = ListPersonUi.Success(persons, personMapper)
    override fun map(errorType: ErrorType) = ListPersonUi.Fail(errorType, resourceProvider)
}
