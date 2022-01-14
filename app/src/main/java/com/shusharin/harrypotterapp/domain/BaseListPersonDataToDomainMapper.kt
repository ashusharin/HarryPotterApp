package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.data.ListPersonDataToDomainMapper
import com.shusharin.harrypotterapp.data.PersonData
import com.shusharin.harrypotterapp.data.PersonDataToDomainMapper
import java.lang.Exception

class BaseListPersonDataToDomainMapper(private val personMapper: PersonDataToDomainMapper) :
    ListPersonDataToDomainMapper {
    override fun map(persons: List<PersonData>) = ListPersonDomain.Success(persons, personMapper)
    override fun map(e: Exception): ListPersonDomain = ListPersonDomain.Fail(e)
}
