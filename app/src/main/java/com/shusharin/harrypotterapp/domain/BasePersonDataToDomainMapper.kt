package com.shusharin.harrypotterapp.domain

import com.shusharin.harrypotterapp.data.PersonDataToDomainMapper

class BasePersonDataToDomainMapper : PersonDataToDomainMapper {
    override fun map(name: String, image: String) = PersonDomain(name, image)
}