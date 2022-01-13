package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.domain.PersonDomain

data class PersonData(private val name: String, private val image: String) :
    Abstract.Object<PersonDomain, PersonDataToDomainMapper> {
    override fun map(mapper: PersonDataToDomainMapper): PersonDomain = mapper.map(name, image)
// TODO: 13.01.2022 ToPersonDb<T, M : Abstract.Mapper>
    }