package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.domain.ListPersonDomain
import java.lang.Exception

interface ListPersonDataToDomainMapper : Abstract.Mapper {

    fun map(persons: List<PersonData>): ListPersonDomain
    fun map(e: Exception): ListPersonDomain
}