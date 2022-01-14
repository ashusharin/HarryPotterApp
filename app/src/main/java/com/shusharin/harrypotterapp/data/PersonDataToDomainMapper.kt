package com.shusharin.harrypotterapp.data

import com.shusharin.harrypotterapp.core.Abstract
import com.shusharin.harrypotterapp.domain.PersonDomain

interface PersonDataToDomainMapper : Abstract.Mapper {
    fun map(name: String, image: String): PersonDomain
}