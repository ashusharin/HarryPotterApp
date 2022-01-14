package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.ui.PersonUi

class PersonDomain(private val name: String, private val image: String) :
    Abstract.Object<PersonUi, PersonDomainToUiMapper> {

    override fun map(mapper: PersonDomainToUiMapper) = mapper.map(name, image)
}
