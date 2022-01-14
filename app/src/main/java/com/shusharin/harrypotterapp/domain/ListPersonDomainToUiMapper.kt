package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.data.ErrorType
import com.shusharin.harrypotterapp.ui.ListPersonUi
import com.shusharin.harrypotterapp.ui.PersonUi

interface ListPersonDomainToUiMapper : Abstract.Mapper {
    fun map(persons: List<PersonDomain>): ListPersonUi
    fun map(errorType: ErrorType) : ListPersonUi
}