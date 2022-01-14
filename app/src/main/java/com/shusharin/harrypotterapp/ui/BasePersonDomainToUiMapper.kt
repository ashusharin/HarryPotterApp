package com.shusharin.harrypotterapp.ui

import com.shusharin.harrypotterapp.domain.PersonDomainToUiMapper

class BasePersonDomainToUiMapper : PersonDomainToUiMapper {
    override fun map(name: String, image: String) = PersonUi.Base(name, image)
}